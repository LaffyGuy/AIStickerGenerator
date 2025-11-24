package com.project.core.theme.previews

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.project.core.theme.material.AIStickerGeneratorTheme

@Composable
fun PreviewScreenContent(
    content: @Composable () -> Unit
) {
    AIStickerGeneratorTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            content()
        }
    }
}