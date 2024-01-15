package com.langfordapps.simplecalories.feature.counter.api

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import com.langfordapps.simplecalories.feature.counter.internal.CounterScreenModel
import com.langfordapps.simplecalories.feature.counter.internal.CounterScreen

object CounterScreenContainer : Screen {
    @Composable
    override fun Content() {
        val presenter = getScreenModel<CounterScreenModel>()
        val state by presenter.state.collectAsState()
        CounterScreen(state)
    }
}
