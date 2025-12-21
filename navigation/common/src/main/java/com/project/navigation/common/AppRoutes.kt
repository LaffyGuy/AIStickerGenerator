package com.project.navigation.common

import kotlinx.serialization.Serializable

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
    ): Route

}
