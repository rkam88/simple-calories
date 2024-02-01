plugins {
    id("langfordapps.compose.library")
}


kotlin {
    sourceSets.commonMain {
        dependencies {
            implementation(project(":core:molecule"))
        }
    }
}

android {
    namespace = "com.langfordapps.simplecalories.core.shared_test"
}
