package com.langfordapps.simplecalories.core.food.api

interface FoodRepository {
    fun getFoodList(): List<Food>
}
