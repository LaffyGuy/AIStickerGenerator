package com.project.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.project.features.gallery.presentation.GalleryScreen
import com.project.features.presentation.MainScreen
import com.project.features.prompts.presentation.promptssample.PromptsScreen
import com.project.presentation.InitScreen

fun NavGraphBuilder.createAppNavGraph(navController: NavController) {
    composable<InitRoute> {
        InitScreen(
            onLaunchMainScreen = {
                navController.navigate(ChatsGraph.ChatsRoute) {
                    popUpTo(0)
                }
            }
        )
    }
    navigation<ChatsGraph>(startDestination = ChatsGraph.ChatsRoute) {
        composable<ChatsGraph.ChatsRoute> { MainScreen() }
    }

    navigation<GalleryGraph>(startDestination = GalleryGraph.GalleryRoute) {
        composable<GalleryGraph.GalleryRoute> { GalleryScreen() }
    }

    navigation<PromptsGraph>(startDestination = PromptsGraph.PromptsRoute) {
        composable<PromptsGraph.PromptsRoute> { PromptsScreen() }
    }

}
