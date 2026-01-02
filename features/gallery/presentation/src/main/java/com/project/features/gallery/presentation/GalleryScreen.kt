package com.project.features.gallery.presentation

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.project.core.theme.previews.PreviewScreenContent
import com.project.core.theme.previews.ScreenPreview
import com.project.features.gallery.domain.entities.GallerySticker
import com.project.features.gallery.presentation.components.DateHeader
import com.project.features.gallery.presentation.components.GalleryItem
import java.time.LocalDate
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter


data class GalleryStickerUi(
    val id: Long,
    @DrawableRes val image: Int,
    val date: LocalDate
)


val imagesList = listOf(
    GalleryStickerUi(
        id = 1,
        image = R.drawable.ic_just,
        date = LocalDate.of(2025, 4, 17)
    ),
    GalleryStickerUi(
        id = 1,
        image = R.drawable.ic_just,
        date = LocalDate.of(2025, 4, 17)
    ),
    GalleryStickerUi(
        id = 1,
        image = R.drawable.ic_just,
        date = LocalDate.of(2025, 4, 12)
    ),
    GalleryStickerUi(
        id = 1,
        image = R.drawable.ic_just,
        date = LocalDate.of(2025, 4, 12)
    ),
    GalleryStickerUi(
        id = 1,
        image = R.drawable.ic_just,
        date = LocalDate.of(2025, 4, 15)
    ),
    GalleryStickerUi(
        id = 1,
        image = R.drawable.ic_just,
        date = LocalDate.of(2025, 4, 15)
    ),
    GalleryStickerUi(
        id = 1,
        image = R.drawable.ic_just,
        date = LocalDate.of(2025, 4, 15)
    ),
    GalleryStickerUi(
        id = 1,
        image = R.drawable.ic_just,
        date = LocalDate.of(2025, 4, 15)
    ),
    GalleryStickerUi(
        id = 1,
        image = R.drawable.ic_just,
        date = LocalDate.of(2025, 4, 15)
    ),
    GalleryStickerUi(
        id = 1,
        image = R.drawable.ic_just,
        date = LocalDate.of(2025, 4, 15)
    )
)

@Composable
fun GalleryScreen(

) {
    GalleryContent(
        images = imagesList
    )
}

@Composable
fun GalleryContent(
    images: List<GalleryStickerUi>
) {

//    val grouped = remember(images) {
//        images.groupBy { it.date }
//            .toSortedMap(compareByDescending { it })
//    }
//
//    LazyColumn(
//        modifier = Modifier.fillMaxSize()
//    ) {
//        grouped.forEach { (date, items) ->
//            stickyHeader {
//                DateHeader(date = date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")))
//            }
//            item {
//                GalleryGrid(images = items)
//            }
//        }
//    }

    val grouped = remember(images) {
        images.groupBy { it.date }
            .toSortedMap(compareByDescending { it })
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        grouped.forEach { (date, items) ->

            stickyHeader {
                DateHeader(
                    date = date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                    modifier = Modifier.fillMaxWidth()
                )
            }

            // Розбиваємо список на рядки по 3 елементи
            items(items.chunked(3)) { rowItems ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    rowItems.forEach { image ->
                        GalleryItem(
                            image = image.image,
                            onClick = {},
                            modifier = Modifier
                                .weight(1f)
                                .aspectRatio(1f)
                        )
                    }

                    // Якщо ряд неповний, заповнюємо порожні weight
                    if (rowItems.size < 3) {
                        repeat(3 - rowItems.size) {
                            Spacer(modifier = Modifier.weight(1f))
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun GalleryGrid(
    images: List<GalleryStickerUi>
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 120.dp),
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        userScrollEnabled = false,
        contentPadding = PaddingValues(4.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        items(images) { image ->
            GalleryItem(
                image = image.image,
                onClick = {}
            )
        }
    }
}

@ScreenPreview
@Composable
fun GalleryContentPreview() {
    PreviewScreenContent {
        GalleryContent(
            images = imagesList
        )
    }
}