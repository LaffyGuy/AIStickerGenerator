package com.project.navigation.bottomnavigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.project.core.essentials.resources.StringResources
import com.project.navigation.ChatsGraph
import com.project.navigation.GalleryGraph
import com.project.navigation.PromptsGraph
import com.project.navigation.R
import com.project.navigation.rememberStringResources
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import javax.inject.Inject


data class AppTab(
    val icon: ImageVector,
    val labelRes: String,
    val graph: Any
)
//
//
//val MainTabs = persistentListOf(
//    AppTab(
//        icon = Icons.Default.List,
//        labelRes = stringResources.getString(R.string.chats),
//        graph = ChatsGraph
//    ),
//    AppTab(
//        icon = Icons.Default.Favorite,
//        labelRes = stringResources.getString(R.string.gallery),
//        graph = GalleryGraph
//    ),
//    AppTab(
//        icon = Icons.Default.Edit,
//        labelRes = stringResources.getString(R.string.prompts),
//        graph = PromptsGraph
//    )
//)

@Composable
fun rememberMainTabs(
    stringResources: StringResources = rememberStringResources()
): ImmutableList<AppTab> {
    return persistentListOf(
        AppTab(
            icon = Icons.Default.List,
            labelRes = stringResources.getString(R.string.chats),
            graph = ChatsGraph
        ),
        AppTab(
            icon = Icons.Default.Favorite,
            labelRes = stringResources.getString(R.string.gallery),
            graph = GalleryGraph
        ),
        AppTab(
            icon = Icons.Default.Edit,
            labelRes = stringResources.getString(R.string.prompts),
            graph = PromptsGraph
        )
    )
}
