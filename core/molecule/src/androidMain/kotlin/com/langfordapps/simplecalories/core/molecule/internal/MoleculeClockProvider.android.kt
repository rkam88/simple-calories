package com.langfordapps.simplecalories.core.molecule.internal

import app.cash.molecule.AndroidUiDispatcher
import app.cash.molecule.RecompositionMode
import kotlin.coroutines.CoroutineContext

internal actual object MoleculeConfigProviderImpl : MoleculeConfigProvider {
    override val recompositionMode: RecompositionMode = RecompositionMode.ContextClock
    override val coroutineContext: CoroutineContext = AndroidUiDispatcher.Main
}
