import com.android.build.api.dsl.ApplicationExtension
import com.langfodapps.plugins.configureAndroid
import com.langfodapps.plugins.configureKmpAndroidTarget
import com.langfodapps.plugins.configureKmpCommon
import com.langfodapps.plugins.configureKmpIosTarget
import com.langfodapps.plugins.findVersionAsString
import com.langfodapps.plugins.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
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
                configureKmpAndroidTarget(this) {
                    implementation(libs.findLibrary("androidx.activity.compose").get())
                }
                configureKmpIosTarget(this)
                configureKmpCommon(this)
            }

            extensions.configure<ApplicationExtension> {
                configureAndroid(this)

                defaultConfig {
                    targetSdk = libs.findVersionAsString("android.targetSdk").toInt()
                }
            }
        }
    }
}