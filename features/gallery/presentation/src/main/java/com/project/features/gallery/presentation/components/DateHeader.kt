package com.project.features.gallery.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun DateHeader(
    date: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = date,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        style = MaterialTheme.typography.titleMedium
    )
}

@Preview(showSystemUi = true)
@Composable
private fun DateHeaderPreview() {
    DateHeader(
        date = "2025-10-12"
    )
}