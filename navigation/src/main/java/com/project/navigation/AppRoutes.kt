package com.project.navigation

import kotlinx.serialization.Serializable

interface Route

@Serializable
data object InitRoute: Route

@Serializable
data object MainRoute: Route