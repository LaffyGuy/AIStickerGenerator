package com.project.features.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.project.core.essentials.entities.ImageSource
import com.project.core.theme.components.ImageView
import com.project.features.domain.entities.GeneratedImage

@Composable
fun StickerResponse(
    path: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        ImageView(
            imageSources = ImageSource.Remote(path),
            modifier = Modifier.fillMaxSize()
        )
    }
}