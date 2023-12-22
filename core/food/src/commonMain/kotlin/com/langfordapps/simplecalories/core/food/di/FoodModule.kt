package com.langfordapps.simplecalories.core.food.di

import com.langfordapps.simplecalories.core.food.api.FoodRepository
import com.langfordapps.simplecalories.core.food.internal.FakeFoodRepository
import org.koin.dsl.module

val foodModule = module {
    single<FoodRepository> {
        FakeFoodRepository()
    }
}
