package com.langfordapps.simplecalories.app

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import com.langfordapps.navigation.VoyagerRouter
import com.langfordapps.simplecalories.feature.home.api.HomeScreenContainer
import org.koin.compose.KoinContext

@Composable
fun App() {
    MaterialTheme {
        KoinContext {
            Navigator(HomeScreenContainer) { navigator ->
                DisposableEffect(navigator) {
                    VoyagerRouter.setNavigator(navigator)
                    onDispose { VoyagerRouter.clearNavigator() }
                }
                SlideTransition(navigator)
            }
        }
    }
}
