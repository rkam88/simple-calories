package com.langfordapps.simplecalories.core.food.di

import com.langfordapps.simplecalories.SimpleCaloriesDatabase
import com.langfordapps.simplecalories.core.food.api.FoodRepository
import com.langfordapps.simplecalories.core.food.internal.DatabaseDriverFactory
import com.langfordapps.simplecalories.core.food.internal.FakeFoodRepository
import org.koin.core.module.Module
import org.koin.dsl.module

val foodModule = module {
    single<FoodRepository> {
        FakeFoodRepository()
    }

    single<SimpleCaloriesDatabase> {
        val databaseDriverFactory: DatabaseDriverFactory = get()
        val driver = databaseDriverFactory.createDriver()
        SimpleCaloriesDatabase(driver = driver)
    }

    platformFoodModuleDeclaration()
}

expect fun Module.platformFoodModuleDeclaration()
