package com.langfordapps.simplecalories.core.molecule.api

import androidx.compose.runtime.Composable
import app.cash.molecule.launchMolecule
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.langfordapps.simplecalories.core.molecule.internal.MoleculeConfigProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.StateFlow

abstract class MoleculeScreenModel<State> : ScreenModel {

    val state: StateFlow<State> by lazy(LazyThreadSafetyMode.NONE) {
        val scope = CoroutineScope(
            screenModelScope.coroutineContext + MoleculeConfigProvider.dispatcher
        )
        scope.launchMolecule(mode = MoleculeConfigProvider.recompositionMode) {
            viewModelState()
        }
    }

    @Composable
    protected abstract fun viewModelState(): State
}
