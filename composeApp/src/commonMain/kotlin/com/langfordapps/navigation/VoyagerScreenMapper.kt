package com.langfordapps.navigation

import cafe.adriel.voyager.core.screen.Screen
import com.langfordapps.simplecalories.core.navigation.api.NavDestination
import com.langfordapps.simplecalories.feature.home.api.HomeScreenContainer

object VoyagerScreenMapper {
    fun mapFrom(destination: NavDestination): Screen {
        return when (destination) {
            is NavDestination.Home -> HomeScreenContainer
        }
    }
}
