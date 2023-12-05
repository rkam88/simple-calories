package com.langfordapps.simplecalories.core.utils

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform