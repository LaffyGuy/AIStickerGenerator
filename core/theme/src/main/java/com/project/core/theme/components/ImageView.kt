package com.project.core.theme.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.SubcomposeAsyncImage
import com.project.core.essentials.entities.ImageSource
import com.project.core.theme.R
import com.project.core.theme.Shapes

@Composable
fun ImageView(
    imageSources: ImageSource,
    modifier: Modifier = Modifier,
    contentDescription: String? = null,
) {
    when (imageSources) {
        ImageSource.Empty -> EmptyImageView(
            modifier = modifier,
            contentDescription = contentDescription
        )

        is ImageSource.Local -> LocalImageView(
            path = imageSources.path,
            modifier = modifier,
            contentDescription = contentDescription
        )

        is ImageSource.Remote -> RemoteImageView(
            url = imageSources.url,
            modifier = modifier,
            contentDescription = contentDescription
        )

        is ImageSource.DrawableRes -> ResDrawableImageView(
            resId = imageSources.resId,
            modifier = modifier,
            contentDescription = contentDescription
        )
    }

}

@Composable
fun EmptyImageView(
    modifier: Modifier = Modifier,
    contentDescription: String? = null
) {
    Image(
        painter = painterResource(R.drawable.ic_empty_image),
        contentDescription = contentDescription,
        modifier = modifier
            .background(
                color = MaterialTheme.colorScheme.secondaryContainer,
                shape = Shapes.MediumRoundedCornerShape
            )
    )
}

@Composable
fun RemoteImageView(
    url: String,
    modifier: Modifier = Modifier,
    contentDescription: String? = null
) {

    SubcomposeAsyncImage(
        model = url,
        modifier = modifier,
        contentDescription = contentDescription,
        error = {
            EmptyImageView(
                modifier = Modifier.matchParentSize(),
                contentDescription = contentDescription
            )
        }
    )
}

@Composable
fun LocalImageView(
    path: String,
    modifier: Modifier = Modifier,
    contentDescription: String? = null
) {
    AsyncImage(
        model = path,
        modifier = modifier,
        contentDescription = contentDescription
    )
}

@Composable
fun ResDrawableImageView(
    resId: Int,
    modifier: Modifier = Modifier,
    contentDescription: String? = null
) {
    Image(
        painter = painterResource(id = resId),
        contentDescription = contentDescription,
        modifier = modifier
    )
}

@Preview(showSystemUi = true)
@Composable
private fun EmptyImageViewPreview() {
    ImageView(
        imageSources = ImageSource.Empty,
        modifier = Modifier.size(200.dp)
    )
}