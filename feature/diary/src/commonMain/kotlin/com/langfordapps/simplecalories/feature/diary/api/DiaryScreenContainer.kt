package com.langfordapps.simplecalories.feature.diary.api

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen

object DiaryScreenContainer : Screen {
    @Composable
    override fun Content() {
        Text("Diary tab content")
    }
}