package com.langfodapps.plugins

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.get

internal fun Project.configureAndroid(
    commonExtension: CommonExtension<*, *, *, *, *>,
) {
    commonExtension.apply {
        compileSdk = libs.findVersionAsString("android.compileSdk").toInt()

        sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
        sourceSets["main"].res.srcDirs("src/androidMain/res")
        sourceSets["main"].resources.srcDirs("src/commonMain/resources")

        defaultConfig {
            minSdk = libs.findVersionAsString("android.minSdk").toInt()
        }

        buildFeatures {
            compose = true
        }
        composeOptions {
            kotlinCompilerExtensionVersion = libs.findVersionAsString("compose.compiler")
        }
        packaging {
            resources {
                excludes += "/META-INF/{AL2.0,LGPL2.1}"
            }
        }
        compileOptions {
            sourceCompatibility = ProjectConfig.javaVersion
            targetCompatibility = ProjectConfig.javaVersion
        }
        dependencies {
            add(debugImplementation, libs.findLibrary("compose.ui.tooling").get())
        }
        testOptions.unitTests.isReturnDefaultValues = true
    }
}