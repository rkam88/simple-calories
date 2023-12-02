plugins {
    `kotlin-dsl`
}

group = "com.langfordapps.buildlogic"

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("composeApplication") {
            id = "langfordapps.compose.application"
            implementationClass = "ComposeAppConventionPlugin"
        }
    }
}