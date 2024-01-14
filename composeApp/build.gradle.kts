plugins {
    id("langfordapps.compose.application")
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
    namespace = "com.langfordapps.simplecalories"

    defaultConfig {
        applicationId = "com.langfordapps.simplecalories"
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}
