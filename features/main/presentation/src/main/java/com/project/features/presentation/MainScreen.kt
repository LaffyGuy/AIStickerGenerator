package com.project.features.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.project.core.theme.previews.PreviewScreenContent


@Composable
fun MainScreen(
) {
    MainContent()
}

@Composable
fun MainContent(
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "MainScreen")
        Spacer(modifier = Modifier.height(16.dp))

    }
}

@Preview(showSystemUi = true)
@Composable
private fun MainContentPreview() {
    PreviewScreenContent {
        MainContent()
    }
}