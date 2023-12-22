plugins {
    id("langfordapps.compose.library")
    alias(libs.plugins.sqldelight)
}

kotlin {
    sourceSets.androidMain {
        dependencies {
            implementation(libs.sqldelight.android.driver)
        }
    }
    sourceSets.commonMain {
        dependencies {
            implementation(project(":core:utils"))
        }
    }
    sourceSets.iosMain {
        dependencies {
            implementation(libs.sqldelight.native.driver)
        }
    }
}

android {
    namespace = "com.langfordapps.simplecalories.core.food"
}

// generate Database files with ./gradlew generateSqlDelightInterface
sqldelight {
    databases {
        create("SimpleCaloriesDatabase") {
            packageName = "com.langfordapps.simplecalories"
            schemaOutputDirectory = file("src/commonMain/sqldelight")
        }
    }
}
