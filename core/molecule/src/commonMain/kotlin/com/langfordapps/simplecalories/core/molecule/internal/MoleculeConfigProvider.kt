package com.langfordapps.simplecalories.core.molecule.internal

import app.cash.molecule.RecompositionMode
import kotlin.coroutines.CoroutineContext

internal interface MoleculeConfigProviderContract {
    val recompositionMode: RecompositionMode
    val coroutineContext: CoroutineContext
}

internal expect object MoleculeConfigProvider : MoleculeConfigProviderContract
