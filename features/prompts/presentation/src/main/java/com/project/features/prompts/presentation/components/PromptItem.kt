package com.project.features.prompts.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.project.core.essentials.entities.ImageSource
import com.project.core.theme.SmallVerticalSpace
import com.project.core.theme.components.ImageView
import com.project.features.prompts.presentation.R

@Composable
fun PromptItem(
    title: String,
    image: ImageSource,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .size(height = 250.dp, width = 180.dp)
            .padding(4.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ImageView(
                modifier = Modifier.size(100.dp),
                imageSources = image
            )
            SmallVerticalSpace()
            Text(text = title)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun PromptItemPreview() {
    PromptItem(
        title = "Sample Prompt",
        image = ImageSource.DrawableRes(resId = R.drawable.sticker__1_)
    )
}