package com.project.features.gallery.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.project.core.theme.previews.PreviewScreenContent
import com.project.core.theme.previews.ScreenPreview

@Composable
fun GalleryScreen(

) {
    GalleryContent()
}

@Composable
fun GalleryContent() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Gallery Screen")
    }
}

@ScreenPreview
@Composable
fun GalleryContentPreview() {
    PreviewScreenContent {
        GalleryContent()
    }
}