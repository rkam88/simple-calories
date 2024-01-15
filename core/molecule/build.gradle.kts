plugins {
    id("langfordapps.compose.library")
}

kotlin {
    sourceSets.commonMain {
        dependencies {
            implementation(project(":core:utils"))
            api(libs.molecule.runtime)
        }
    }
}

android {
    namespace = "com.langfordapps.simplecalories.core.molecule"
}
