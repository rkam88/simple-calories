package com.langfordapps.simplecalories.feature.history.api

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen

object HistoryScreenContainer : Screen {
    @Composable
    override fun Content() {
        Text("History tab content")
    }
}