package com.project.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.createGraph
import com.project.navigation.bottomnavigation.BottomNavigationBar
import com.project.navigation.bottomnavigation.rememberMainTabs


@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    startDestination: Route = InitRoute
) {
    val navController = rememberNavController()
    val navGraph = remember {
        navController.createGraph(startDestination) {
            createAppNavGraph(navController)
        }
    }

    val currentBackStackEntry by navController.currentBackStackEntryAsState()

    Scaffold(
        modifier = modifier,
        bottomBar = {
            if (currentBackStackEntry?.destination.routeClass() != InitRoute::class) {
                BottomNavigationBar(
                    tabs = rememberMainTabs(),
                    navController = navController
                )
            }
        }
    ) { paddingValues ->
        NavHost(
            modifier = Modifier.fillMaxSize().padding(paddingValues),
            navController = navController,
            graph = navGraph
        )
    }

}