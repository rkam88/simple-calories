package com.langfordapps.simplecalories.core.food.api

data class Food(
    val id: Int,
    val name: String,
    val portions: List<Portion>,
)

sealed class Portion {
    abstract val id: Int
    abstract val foodId: Int
    abstract val calories: Float

    data class PerGram(
        override val id: Int,
        override val foodId: Int,
        override val calories: Float,
    ) : Portion()

    data class Custom(
        override val id: Int,
        override val foodId: Int,
        override val calories: Float,
        val name: String,
    ) : Portion()
}
