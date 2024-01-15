package com.langfordapps.simplecalories.feature.counter.internal

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.langfordapps.simplecalories.core.molecule.api.MoleculeScreenModel
import com.langfordapps.simplecalories.core.navigation.api.Router

internal class CounterScreenModel(
    private val router: Router,
) : MoleculeScreenModel<CounterState>() {

    @Composable
    override fun viewModelState(): CounterState {
        var counterValue by remember { mutableIntStateOf(0) }
        return CounterState(
            value = counterValue,
            onIncrementPressed = { counterValue += 1 },
            onDecrementPressed = { counterValue -= 1 },
            onBackPressed = { router.pop() },
        )
    }
}
