package com.langfordapps.simplecalories.core.food.api

import kotlinx.datetime.LocalDateTime

data class FoodLogEntry(
    val id: Int,
    val date: LocalDateTime,
    val food: Food,
    val portion: Portion,
    val amount: Float,
    val caloriesConsumed: Float,
) {
    companion object {
        private fun calculateConsumedCalories(portion: Portion, amount: Float): Float {
            return portion.calories * amount
        }
    }
}
