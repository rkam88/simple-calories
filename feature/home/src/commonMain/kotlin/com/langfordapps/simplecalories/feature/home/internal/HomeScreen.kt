package com.langfordapps.simplecalories.feature.home.internal

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.langfordapps.simplecalories.core.food.api.FoodRepository
import com.langfordapps.simplecalories.core.navigation.api.NavDestination
import com.langfordapps.simplecalories.core.navigation.api.Router
import com.langfordapps.simplecalories.core.utils.getPlatform
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.koinInject

@OptIn(ExperimentalResourceApi::class)
@Composable
internal fun HomeScreen() {
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
