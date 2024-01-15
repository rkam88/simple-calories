package com.langfordapps.simplecalories.core.molecule.internal

import app.cash.molecule.RecompositionMode
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

internal actual object MoleculeConfigProvider : MoleculeConfigProviderContract {
    override val recompositionMode: RecompositionMode = RecompositionMode.Immediate
    override val dispatcher: CoroutineContext = Dispatchers.Main
}
