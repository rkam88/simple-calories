package com.langfodapps.plugins

import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.compose.ComposeExtension
import org.jetbrains.compose.ComposePlugin

val Project.libs: VersionCatalog
    get() = extensions.getByType<VersionCatalogsExtension>().named("libs")

fun VersionCatalog.findVersionAsString(alias: String): String {
    return findVersion(alias).get().toString()
}

val Project.composePluginLibs: ComposePlugin.Dependencies
    get() = extensions.getByType<ComposeExtension>().dependencies

@Suppress("UnusedReceiverParameter")
val DependencyHandlerScope.debugImplementation
    get() = "debugImplementation"

@Suppress("UnusedReceiverParameter")
val DependencyHandlerScope.testImplementation
    get() = "testImplementation"
