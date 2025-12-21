package com.project.navigation.host.bottomnavigation

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph
import androidx.navigation.compose.currentBackStackEntryAsState
import com.project.navigation.host.routeClass

@Composable
fun BottomNavigationBar(
    tabs: List<AppTab>,
    navController: NavController
) {


    NavigationBar(
        containerColor = Color.White
    ) {
        val currentBackStackEntry by navController.currentBackStackEntryAsState()
        val closesNavGraphDestination = currentBackStackEntry?.destination?.hierarchy?.first {
            it is NavGraph
        }

        val closestNavGraphClass = closesNavGraphDestination.routeClass()
        val currentTab = tabs.firstOrNull { it.graph::class == closestNavGraphClass }

        tabs.forEach { tab ->
            NavigationBarItem(
                selected = currentTab == tab,
                onClick = {
                    navController.navigate(tab.graph)
                },
                icon = {
                    Icon(imageVector = tab.icon, contentDescription = null)
                },
                label = {
                    Text(text = tab.labelRes)
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = MaterialTheme.colorScheme.tertiaryContainer,
                    selectedIconColor = MaterialTheme.colorScheme.onTertiaryContainer
                )
            )
        }

    }
}