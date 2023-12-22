package com.langfordapps.simplecalories.core.food.di

import com.langfordapps.simplecalories.core.food.internal.DatabaseDriverFactory
import org.koin.core.module.Module

actual fun Module.platformFoodModuleDeclaration() {
    single<DatabaseDriverFactory> {
        DatabaseDriverFactory()
    }
}
