package com.langfordapps.simplecalories.core.molecule.internal

import app.cash.molecule.DisplayLinkClock
import app.cash.molecule.RecompositionMode
import kotlin.coroutines.CoroutineContext

internal actual object MoleculeConfigProvider : MoleculeConfigProviderContract {
    override val recompositionMode: RecompositionMode = RecompositionMode.ContextClock
    override val coroutineContext: CoroutineContext = DisplayLinkClock
}
