package com.project.presentation

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalConfiguration
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.project.core.essentials.entities.ImageSource
import com.project.core.theme.components.LoadResultView
import com.project.core.theme.previews.PreviewScreenContent
import com.project.core.theme.previews.ScreenPreview
import com.project.domain.entities.KeyFeature
import com.project.presentation.component.KeyFeaturesPager
import java.time.ZonedDateTime

@Composable
fun InitScreen(
    onLaunchMainScreen: () -> Unit
) {
    val viewModel: InitViewModel = hiltViewModel()
    val loadResult by viewModel.stateFlow.collectAsStateWithLifecycle()
    val effects by viewModel.effects.collectAsStateWithLifecycle()


    LaunchedEffect(effects.launchMainScreen) {
        if (effects.launchMainScreen != null) {
            onLaunchMainScreen()
            viewModel.onLaunchMainScreenProcessed()
        }
    }

    LoadResultView(
        loadResult = loadResult,
        onTryAgainAction = {},
        content = { state ->
            InitContent(
                state = state,
                onLetsGoAction = viewModel::letsGo
            )
        },
        exceptionToMessageMapper = viewModel.exceptionToMessageMapper
    )

}

@Composable
fun InitContent(
    state: InitUiState,
    onLetsGoAction: () -> Unit
) {
    val configuration = LocalConfiguration.current
    if (configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
        InitLandscapeContent(
            state = state,
            onLetsGoAction = onLetsGoAction,
            configuration = configuration
        )
    } else {
        InitPortraitContent(
            state = state,
            onLetsGoAction = onLetsGoAction,
            configuration = configuration
        )
    }
}

@Composable
fun InitPortraitContent(
    state: InitUiState,
    onLetsGoAction: () -> Unit,
    configuration: Configuration
) {
    KeyFeaturesPager(
        configuration = configuration,
        keyFeatures = state.keyFeatures,
        onLetsGoAction = onLetsGoAction
    )
}

@Composable
fun InitLandscapeContent(
    state: InitUiState,
    onLetsGoAction: () -> Unit,
    configuration: Configuration
) {
    KeyFeaturesPager(
        configuration = configuration,
        keyFeatures = state.keyFeatures,
        onLetsGoAction = onLetsGoAction
    )
}

@ScreenPreview
@Composable
private fun InitContentPreview() {
    PreviewScreenContent {
        InitContent(
            state = InitUiState(
                keyFeatures = listOf(
                    KeyFeature(
                        id = 0L,
                        title = "Welcome to Money Manager",
                        description = "Manage your finances effectively with our app.",
                        image = ImageSource.Empty,
                        lastDisplayTime = ZonedDateTime.now()
                    ),
                    KeyFeature(
                        id = 0L,
                        title = "Welcome to Money Manager",
                        description = "Manage your finances effectively with our app.",
                        image = ImageSource.Empty,
                        lastDisplayTime = ZonedDateTime.now()
                    )
                )
            ),
            onLetsGoAction = {}
        )
    }
}