package com.langfordapps.simplecalories.core.navigation.api

interface Router {
    fun push(destination: NavDestination)
    fun pop()
}
