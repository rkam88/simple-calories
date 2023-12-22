package com.langfordapps.simplecalories.core.food.internal

import app.cash.sqldelight.db.SqlDriver
import com.langfordapps.simplecalories.SimpleCaloriesDatabase

internal object DatabaseDriverFactoryConstants {
    val schema = SimpleCaloriesDatabase.Schema
    val name = SimpleCaloriesDatabase::class.simpleName + ".db"
}

internal expect class DatabaseDriverFactory {
    fun createDriver(): SqlDriver
}
