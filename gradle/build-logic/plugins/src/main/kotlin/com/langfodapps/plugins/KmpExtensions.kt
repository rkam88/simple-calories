package com.langfodapps.plugins

import org.gradle.api.Project
import org.jetbrains.compose.ExperimentalComposeLibrary
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.plugin.KotlinDependencyHandler

internal fun Project.configureKmpAndroidTarget(
    kotlinMultiplatformExtension: KotlinMultiplatformExtension,
    additionalDependencies: KotlinDependencyHandler.() -> Unit = {},
) {
    kotlinMultiplatformExtension.apply {
        androidTarget {
            compilations.all {
                kotlinOptions {
                    jvmTarget = "1.8"
                }
            }
        }

        with(sourceSets) {
            androidMain.dependencies {
                implementation(libs.findLibrary("compose.ui").get())
                implementation(libs.findLibrary("compose.ui.tooling.preview").get())

                this.additionalDependencies()
            }
        }
    }
}

internal fun Project.configureKmpIosTarget(
    kotlinMultiplatformExtension: KotlinMultiplatformExtension,
) {
    kotlinMultiplatformExtension.apply {
        listOf(
            iosX64(),
            iosArm64(),
            iosSimulatorArm64()
        ).forEach { iosTarget ->
            iosTarget.binaries.framework {
                baseName = "ComposeApp"
                isStatic = true
            }
        }
    }
}

internal fun Project.configureKmpCommon(
    kotlinMultiplatformExtension: KotlinMultiplatformExtension,
) {
    kotlinMultiplatformExtension.apply {
        with(sourceSets) {
            commonMain.dependencies {
                implementation(composePluginLibs.runtime)
                implementation(composePluginLibs.foundation)
                implementation(composePluginLibs.material)
                @OptIn(ExperimentalComposeLibrary::class)
                implementation(composePluginLibs.components.resources)
            }
        }
    }
}