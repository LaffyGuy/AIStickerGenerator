package com.project.features.gallery.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.project.core.essentials.entities.ImageSource
import com.project.core.theme.components.ImageView
import com.project.features.gallery.presentation.R

@Composable
fun GalleryItem(
    image: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    date: String? = null

) {
    Box(
        modifier = modifier
            .aspectRatio(1f)
            .clickable { onClick() }
    ) {
        ImageView(
            imageSources = ImageSource.DrawableRes(image),
            modifier = Modifier.fillMaxSize().background(Color.Gray)
        )

        if (date != null) {
            Text(
                text = date,
                color = Color.White,
                fontSize = 12.sp,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .background(
                        Color.Black.copy(alpha = 0.5f),
                        RoundedCornerShape(topEnd = 8.dp)
                    )
                    .padding(8.dp)
            )

        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun GalleryItemPreview() {
    GalleryItem(
        image = R.drawable.ic_just,
        onClick = {},
        date = "10.11.2025"
    )

}