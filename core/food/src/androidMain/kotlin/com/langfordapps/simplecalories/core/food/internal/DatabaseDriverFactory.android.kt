package com.langfordapps.simplecalories.core.food.internal

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver

internal actual class DatabaseDriverFactory(
    private val context: Context,
) {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(
            schema = DatabaseDriverFactoryConstants.schema,
            context = context,
            name = DatabaseDriverFactoryConstants.name,
        )
    }
}
