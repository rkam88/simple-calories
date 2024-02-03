package com.langfordapps.simplecalories.feature.home.internal

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Face
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabDisposable
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.langfordapps.simplecalories.core.food.api.FoodRepository
import com.langfordapps.simplecalories.core.navigation.api.NavDestination
import com.langfordapps.simplecalories.core.navigation.api.Router
import com.langfordapps.simplecalories.core.utils.getPlatform
import com.langfordapps.simplecalories.feature.catalogue.api.CatalogueScreenContainer
import com.langfordapps.simplecalories.feature.diary.api.DiaryScreenContainer
import com.langfordapps.simplecalories.feature.history.api.HistoryScreenContainer
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.koinInject

@Composable
internal fun HomeScreen() {
    val homeTabs = rememberHomeTabs()

    TabNavigator(
        tab = homeTabs.first(),
        tabDisposable = { tabNavigator ->
            TabDisposable(
                navigator = tabNavigator,
                tabs = homeTabs,
            )
        }
    ) {
        Scaffold(
            content = {
                CurrentTab()
            },
            bottomBar = {
                BottomNavigation {
                    homeTabs.forEach { TabNavigationItem(it) }
                }
            }
        )
    }
}

@Composable
private fun rememberHomeTabs() = remember {
    listOf(
        HomeTab(
            icon = Icons.Default.AccountBox,
            index = 0u,
            title = "Diary",
            screen = DiaryScreenContainer,
        ),
        HomeTab(
            icon = Icons.Default.DateRange,
            index = 1u,
            title = "History",
            screen = HistoryScreenContainer,
        ),
        HomeTab(
            icon = Icons.Default.Face,
            index = 2u,
            title = "Catalogue",
            screen = CatalogueScreenContainer,
        ),
        HomeTab(
            icon = Icons.Default.Build,
            index = 3u,
            title = "Example",
            screen = ExampleScreen,
        )
    )
}

@Composable
private fun RowScope.TabNavigationItem(tab: Tab) {
    val tabNavigator = LocalTabNavigator.current

    BottomNavigationItem(
        selected = tabNavigator.current.key == tab.key,
        onClick = { tabNavigator.current = tab },
        icon = {
            Icon(
                painter = requireNotNull(tab.options.icon),
                contentDescription = tab.options.title,
            )
        }
    )
}

object ExampleScreen : Screen {
    @OptIn(ExperimentalResourceApi::class)
    @Composable
    override fun Content() {
        Column(Modifier.fillMaxSize()) {
            val foodRepository = koinInject<FoodRepository>()

            var greetingText by remember { mutableStateOf("Hello World!") }
            var showImage by remember { mutableStateOf(false) }
            Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                Button(onClick = {
                    greetingText = "Compose: ${getPlatform().name}"
                    showImage = !showImage
                }) {
                    Text(greetingText)
                }
                AnimatedVisibility(showImage) {
                    Image(
                        painterResource("compose-multiplatform.xml"),
                        null
                    )
                }
                foodRepository.getFoodList().forEach {
                    Text(text = it.name)
                }

                val router = koinInject<Router>()
                Button(onClick = { router.push(NavDestination.Counter) }) {
                    Text("Open counter")
                }
            }
        }
    }
}
