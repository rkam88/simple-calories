package com.langfordapps.simplecalories.core.molecule.internal

import app.cash.molecule.RecompositionMode
import kotlin.coroutines.CoroutineContext

interface MoleculeConfigProvider {
    val recompositionMode: RecompositionMode
    val coroutineContext: CoroutineContext
}

internal expect object MoleculeConfigProviderImpl : MoleculeConfigProvider
