package com.langfordapps.simplecalories.feature.counter.internal

internal data class CounterState(
    val value: Int,
    val onIncrementPressed: () -> Unit,
    val onDecrementPressed: () -> Unit,
    val onBackPressed: () -> Unit,
)
