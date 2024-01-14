package com.langfordapps.simplecalories.feature.home.api

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import com.langfordapps.simplecalories.feature.home.internal.HomeScreen

object HomeScreenContainer : Screen {
    @Composable
    override fun Content() = HomeScreen()
}