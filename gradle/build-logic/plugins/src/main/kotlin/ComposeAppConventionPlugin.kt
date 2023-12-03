import com.android.build.api.dsl.ApplicationExtension
import com.langfodapps.plugins.ProjectConfig
import com.langfodapps.plugins.composePluginLibs
import com.langfodapps.plugins.debugImplementation
import com.langfodapps.plugins.findVersionAsString
import com.langfodapps.plugins.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.get
import org.jetbrains.compose.ExperimentalComposeLibrary
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class ComposeAppConventionPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        with(project) {
            pluginManager.apply {
                apply("org.jetbrains.compose")
                apply("com.android.application")
                apply("org.jetbrains.kotlin.multiplatform")
            }

            extensions.configure<KotlinMultiplatformExtension> {
                androidTarget {
                    compilations.all {
                        kotlinOptions {
                            jvmTarget = "1.8"
                        }
                    }
                }

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

                with(sourceSets) {
                    androidMain.dependencies {
                        implementation(libs.findLibrary("compose.ui").get())
                        implementation(libs.findLibrary("compose.ui.tooling.preview").get())
                        implementation(libs.findLibrary("androidx.activity.compose").get())
                    }

                    commonMain.dependencies {
                        implementation(composePluginLibs.runtime)
                        implementation(composePluginLibs.foundation)
                        implementation(composePluginLibs.material)
                        @OptIn(ExperimentalComposeLibrary::class)
                        implementation(composePluginLibs.components.resources)
                    }
                }
            }

            extensions.configure<ApplicationExtension> {
                compileSdk = libs.findVersionAsString("android.compileSdk").toInt()

                sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
                sourceSets["main"].res.srcDirs("src/androidMain/res")
                sourceSets["main"].resources.srcDirs("src/commonMain/resources")

                defaultConfig {
                    minSdk = libs.findVersionAsString("android.minSdk").toInt()
                    targetSdk = libs.findVersionAsString("android.targetSdk").toInt()
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
            }
        }
    }
}