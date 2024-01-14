plugins {
    id("langfordapps.compose.library")
}

kotlin {
    sourceSets.commonMain {
        dependencies {
            implementation(project(":core:utils"))
            implementation(project(":core:food"))
            implementation(project(":core:navigation"))
        }
    }
}

android {
    namespace = "com.langfordapps.simplecalories.feature.home"
}