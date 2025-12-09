package com.project.navigation

import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDestination
import kotlinx.serialization.Serializable
import kotlin.reflect.KClass

interface Route

@Serializable
data object InitRoute : Route

@Serializable
data object ChatsGraph {
    @Serializable
    data object ChatsRoute : Route
}

@Serializable
data object GalleryGraph {
    @Serializable
    data object GalleryRoute : Route
}


@Serializable
data object PromptsGraph {
    @Serializable
    data object PromptsRoute : Route

    @Serializable
    data class PromptDetailsRoute(
        val promptId: Long
    )

}

fun NavBackStackEntry?.routeClass(): KClass<*>? {
    return this?.destination.routeClass()
}


fun NavDestination?.routeClass(): KClass<*>? {
    return this?.route
        ?.split("/")
        ?.first()
        ?.let { className ->
            generateSequence(className, :: replaceLastDotByDollar)
                .mapNotNull(::tryParseClass)
                .firstOrNull()
        }

}

private fun tryParseClass(className: String): KClass<*>? {
    return runCatching { Class.forName(className).kotlin}.getOrNull()
}

private fun replaceLastDotByDollar(input: String): String? {
    val index = input.lastIndexOf('.')
    return if (index != -1) {
        String(input.toCharArray().apply { set(index, '$') })
    } else {
        null
    }
}
