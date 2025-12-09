package com.project.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.project.core.essentials.resources.StringResources
import dagger.hilt.android.EntryPointAccessors

@Composable
fun rememberStringResources(): StringResources {
    val context = LocalContext.current.applicationContext
    return EntryPointAccessors.fromApplication(
        context,
        StringResourcesEntryPoint::class.java
    ).stringResources()
}