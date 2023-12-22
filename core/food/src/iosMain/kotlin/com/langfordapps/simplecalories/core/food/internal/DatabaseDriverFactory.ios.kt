package com.langfordapps.simplecalories.core.food.internal

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver

internal actual class DatabaseDriverFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(
            DatabaseDriverFactoryConstants.schema,
            DatabaseDriverFactoryConstants.name,
        )
    }
}
