package com.project.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.project.features.presentation.MainScreen
import com.project.presentation.InitScreen

fun NavGraphBuilder.createAppNavGraph(navController: NavController) {
    composable<InitRoute> {
        InitScreen(
            onLaunchMainScreen = {
                navController.navigate(MainRoute) {
                    popUpTo(0)
                }
            }
        )
    }
    composable<MainRoute> { MainScreen() }
}
