package com.langfordapps.simplecalories.core.food.internal

import com.langfordapps.simplecalories.core.food.api.Food
import com.langfordapps.simplecalories.core.food.api.FoodRepository
import com.langfordapps.simplecalories.core.food.api.Portion

internal class FakeFoodRepository : FoodRepository {
    override fun getFoodList(): List<Food> {
        return listOf(
            Food(1, "Apple", listOf(Portion.PerGram(1, 1, 0.5f))),
            Food(2, "Orange", listOf(Portion.PerGram(2, 2, 0.6f))),
        )
    }
}
