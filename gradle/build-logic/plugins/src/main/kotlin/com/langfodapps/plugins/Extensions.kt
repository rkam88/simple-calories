package com.langfodapps.plugins

import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.getByType

val Project.libs: VersionCatalog
    get() = extensions.getByType<VersionCatalogsExtension>().named("libs")

fun VersionCatalog.findVersionAsString(alias: String): String {
    return findVersion(alias).get().toString()
}

@Suppress("UnusedReceiverParameter")
val DependencyHandlerScope.debugImplementation
    get() = "debugImplementation"

object ProjectConfig {
    val javaVersion: JavaVersion = JavaVersion.VERSION_1_8
}

