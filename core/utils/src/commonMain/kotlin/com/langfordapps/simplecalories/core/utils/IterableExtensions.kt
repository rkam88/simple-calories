package com.langfordapps.simplecalories.core.utils

inline fun <T> Iterable<T>.sumBy(selector: (T) -> Float): Float {
    var sum = 0f
    for (element in this) {
        sum += selector(element)
    }
    return sum
}