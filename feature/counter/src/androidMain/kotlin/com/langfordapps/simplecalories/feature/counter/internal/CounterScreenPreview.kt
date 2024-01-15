package com.langfordapps.simplecalories.feature.counter.internal

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
private fun CounterScreenPreview() {
    CounterScreen(
        state = CounterState(
            value = 0,
            onIncrementPressed = {},
            onDecrementPressed = {},
            onBackPressed = {},
        )
    )
}
