plugins {
    id("langfordapps.compose.library")
}

kotlin {
    sourceSets.commonMain {
        dependencies {
            implementation(project(":core:utils"))
            implementation(project(":core:food"))
            implementation(project(":core:navigation"))
            implementation(project(":feature:catalogue"))
            implementation(project(":feature:diary"))
            implementation(project(":feature:history"))
        }
    }
}

android {
    namespace = "com.langfordapps.simplecalories.feature.home"
}