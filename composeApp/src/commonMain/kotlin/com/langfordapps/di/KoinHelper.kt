package com.langfordapps.di

import com.langfordapps.simplecalories.core.food.di.foodModule
import com.langfordapps.simplecalories.core.molecule.moleculeModule
import com.langfordapps.simplecalories.feature.counter.di.counterModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

object KoinHelper {

    private val modules = listOf(
        moleculeModule,
        foodModule,
        navigationModule,
        counterModule,
    )

    fun doInit(appDeclaration: KoinAppDeclaration = {}) {
        startKoin {
            modules(modules)
            appDeclaration()
        }
    }
}
