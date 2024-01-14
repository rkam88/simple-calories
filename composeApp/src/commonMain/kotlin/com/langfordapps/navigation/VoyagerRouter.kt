package com.langfordapps.navigation

import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.Navigator
import com.langfordapps.simplecalories.core.navigation.api.NavDestination
import com.langfordapps.simplecalories.core.navigation.api.Router

internal object VoyagerRouter : Router {
    private var navigator: Navigator? = null
    private var pendingNavigationEvent: NavigationEvent? = null

    fun setNavigator(navigator: Navigator) {
        VoyagerRouter.navigator = navigator
        handlePendingNavigationEvent()
    }

    fun clearNavigator() {
        navigator = null
    }

    private fun handlePendingNavigationEvent() {
        val navigator = navigator ?: return
        val event = pendingNavigationEvent.also { pendingNavigationEvent = null }
        when (event) {
            is NavigationEvent.Pop -> navigator.pop()
            is NavigationEvent.Push -> navigator.push(event.target)
            null -> Unit
        }
    }

    override fun push(destination: NavDestination) {
        val target = VoyagerScreenMapper.mapFrom(destination)
        navigator?.push(target) ?: run { pendingNavigationEvent = NavigationEvent.Push(target) }
    }

    override fun pop() {
        navigator?.pop() ?: run { pendingNavigationEvent = NavigationEvent.Pop }
    }
}

private sealed class NavigationEvent {
    data object Pop : NavigationEvent()
    data class Push(val target: Screen) : NavigationEvent()
}
