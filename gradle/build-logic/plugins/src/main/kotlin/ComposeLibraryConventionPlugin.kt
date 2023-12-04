import com.android.build.api.dsl.LibraryExtension
import com.langfodapps.plugins.configureAndroid
import com.langfodapps.plugins.configureKmpAndroidTarget
import com.langfodapps.plugins.configureKmpCommon
import com.langfodapps.plugins.configureKmpIosTarget
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class ComposeLibraryConventionPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        with(project) {
            pluginManager.apply {
                apply("org.jetbrains.compose")
                apply("com.android.library")
                apply("org.jetbrains.kotlin.multiplatform")
            }

            extensions.configure<KotlinMultiplatformExtension> {
                configureKmpAndroidTarget(this)
                configureKmpIosTarget(this)
                configureKmpCommon(this)
            }

            extensions.configure<LibraryExtension> {
                configureAndroid(this)
            }
        }
    }
}