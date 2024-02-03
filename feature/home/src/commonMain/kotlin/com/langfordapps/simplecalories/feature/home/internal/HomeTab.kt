package com.langfordapps.simplecalories.feature.home.internal

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions

internal class HomeTab(
    private val icon: ImageVector,
    private val index: UShort,
    private val title: String,
    private val screen: Screen,
) : Tab, Screen by screen {
    override val key: ScreenKey
        get() = screen.key

    override val options: TabOptions
        @Composable
        get() {
            val icon = rememberVectorPainter(icon)
            return remember {
                TabOptions(
                    index = index,
                    title = title,
                    icon = icon,
                )
            }
        }
}