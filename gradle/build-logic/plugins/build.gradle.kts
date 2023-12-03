plugins {
    `kotlin-dsl`
}

group = "com.langfordapps.buildlogic"

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.jetbrains.compose.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("composeApplication") {
            id = "langfordapps.compose.application"
            implementationClass = "ComposeAppConventionPlugin"
        }
    }
}