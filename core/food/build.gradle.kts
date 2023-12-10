plugins {
    id("langfordapps.compose.library")
}

kotlin {
    sourceSets.commonMain {
        dependencies {
            implementation(project(":core:utils"))
        }
    }
}

android {
    namespace = "com.langfordapps.simplecalories.core.food"
}