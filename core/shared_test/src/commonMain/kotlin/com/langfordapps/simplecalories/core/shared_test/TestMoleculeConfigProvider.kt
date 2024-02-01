package com.langfordapps.simplecalories.core.shared_test

import app.cash.molecule.RecompositionMode
import com.langfordapps.simplecalories.core.molecule.internal.MoleculeConfigProvider
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

object TestMoleculeConfigProvider : MoleculeConfigProvider {
    override val recompositionMode: RecompositionMode = RecompositionMode.Immediate
    override val coroutineContext: CoroutineContext = EmptyCoroutineContext
}
