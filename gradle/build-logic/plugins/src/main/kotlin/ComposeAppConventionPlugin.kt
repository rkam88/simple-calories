import org.gradle.api.Plugin
import org.gradle.api.Project

class ComposeAppConventionPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        with(project) {
            pluginManager.apply {
                apply("org.jetbrains.compose")
                apply("com.android.application")
                apply("org.jetbrains.kotlin.multiplatform")
            }
        }
    }
}