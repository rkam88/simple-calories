package com.langfordapps.simplecalories.feature.catalogue.api

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen

object CatalogueScreenContainer : Screen {
    @Composable
    override fun Content() {
        Text("Catalogue tab content")
    }
}