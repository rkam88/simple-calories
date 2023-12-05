rootProject.name = "SimpleCalories"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    includeBuild("gradle/build-logic")
    repositories {
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

include(":composeApp")

// Automatically include app modules in the core and feature folders
rootDir.getSubFolders()
    .filter { it.name == "core" || it.name == "feature" }
    .flatMap { it.getSubFolders() }
    .onEach(::createModuleFilesIfNeeded)
    .forEach { include(":${it.parentFile.name}:${it.name}") }

fun File.getSubFolders(): List<File> {
    return this.listFiles()?.filter { it.isDirectory && it.isHidden.not() } ?: emptyList()
}

fun createModuleFilesIfNeeded(module: File) {
    if (module.getSubFolders().isEmpty()) {
        val parentName = module.parentFile.name
        val moduleName = module.name

        val pathPrefix = "src/"
        val pathSuffix = "/kotlin/com/langfordapps/simplecalories/$parentName/$moduleName"

        // create folder structure
        listOf("androidMain", "commonMain", "iosMain")
            .map { pathPrefix + it + pathSuffix }
            .map { targetPath -> File(module, targetPath) }
            .forEach { newDir -> newDir.mkdirs() }

        // Create Android manifest
        File(module, "src/androidMain/AndroidManifest.xml")
            .takeIf { it.exists().not() }
            ?.apply {
                createNewFile()
                writeText(
                    """
                    <?xml version="1.0" encoding="utf-8"?>
                    <manifest />
                    
                    """.trimIndent()
                )
            }

        // Create build.gradle.kts
        File(module, "build.gradle.kts")
            .takeIf { it.exists().not() }
            ?.apply {
                createNewFile()
                writeText(
                    """
                    plugins {
                        id("langfordapps.compose.library")
                    }

                    android {
                        namespace = "com.langfordapps.simplecalories.$parentName.$moduleName"
                    }
                """.trimIndent()
                )
            }
    }
}