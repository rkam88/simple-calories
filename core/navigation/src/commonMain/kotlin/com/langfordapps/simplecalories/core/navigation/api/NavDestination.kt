package com.langfordapps.simplecalories.core.navigation.api

sealed class NavDestination {
    data object Home : NavDestination()
    data object Counter: NavDestination()
}
