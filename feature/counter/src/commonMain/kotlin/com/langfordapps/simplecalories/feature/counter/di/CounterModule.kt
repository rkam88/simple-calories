package com.langfordapps.simplecalories.feature.counter.di

import com.langfordapps.simplecalories.feature.counter.internal.CounterScreenModel
import org.koin.dsl.module

val counterModule = module {
    factory {
        CounterScreenModel(
            router = get(),
        )
    }
}
