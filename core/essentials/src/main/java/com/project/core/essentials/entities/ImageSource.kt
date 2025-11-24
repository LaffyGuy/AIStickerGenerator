package com.project.core.essentials.entities

sealed interface ImageSource {

    data object Empty : ImageSource

    data class Remote(
        val url: String
    ) : ImageSource

    data class Local(
        val path: String
    ) : ImageSource

    data class ResDrawable(
        val resId: Int
    ) : ImageSource

}