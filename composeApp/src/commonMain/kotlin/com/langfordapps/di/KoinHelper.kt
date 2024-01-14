package com.langfordapps.di

import com.langfordapps.simplecalories.core.food.di.foodModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

object KoinHelper {

    private val modules = listOf(
        foodModule,
        navigationModule,
    )

    fun doInit(appDeclaration: KoinAppDeclaration = {}) {
        startKoin {
            modules(modules)
            appDeclaration()
        }
    }
}
