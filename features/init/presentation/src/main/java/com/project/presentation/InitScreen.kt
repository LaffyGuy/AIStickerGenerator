package com.project.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.project.core.theme.Dimens
import com.project.core.theme.MediumVerticalSpace
import com.project.core.theme.components.LoadResultView
import com.project.core.theme.components.ProgressButton
import com.project.domain.entities.KeyFeature

@Composable
fun InitScreen() {
    val viewModel: InitViewModel = hiltViewModel()
    val loadResult by viewModel.stateFlow.collectAsStateWithLifecycle()

    LoadResultView(
        loadResult = loadResult,
        onTryAgainAction = {},
        content = { state ->
            InitContent(
                state = state,
                onLetsGoAction = viewModel::letsGo
            )
        }
    )

}

@Composable
fun InitContent(
    state: State,
    onLetsGoAction: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(Dimens.MediumPadding),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = state.keyFeature.title)
        MediumVerticalSpace()
        Text(text = state.keyFeature.description)
        MediumVerticalSpace()
        ProgressButton(
            isInProgress = state.isCheckAuthInProgress,
            text = stringResource(R.string.let_s_go),
            onClick = onLetsGoAction
        )
    }
}

@Preview(showSystemUi = true)
@Composable
private fun InitContentPreview() {
    InitContent(
        state = State(
            keyFeature = KeyFeature(
                id = 0L,
                title = "Welcome to Money Manager",
                description = "Manage your finances effectively with our app."
            ),
            isCheckAuthInProgress = true
        ),
        onLetsGoAction = {}
    )
}