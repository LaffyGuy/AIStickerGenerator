package com.project.navigation.host.bottomnavigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.project.core.essentials.resources.StringResources
import com.project.navigation.common.ChatsGraph
import com.project.navigation.common.GalleryGraph
import com.project.navigation.common.PromptsGraph
import com.project.navigation.host.R
import com.project.navigation.host.rememberStringResources
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

data class AppTab(
    val icon: ImageVector,
    val labelRes: String,
    val graph: Any
)

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