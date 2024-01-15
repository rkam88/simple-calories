plugins {
    id("langfordapps.compose.library")
}

kotlin {
    sourceSets.commonMain {
        dependencies {
            implementation(project(":core:molecule"))
            implementation(project(":core:navigation"))
        }
    }
}

android {
    namespace = "com.langfordapps.simplecalories.feature.counter"
}
