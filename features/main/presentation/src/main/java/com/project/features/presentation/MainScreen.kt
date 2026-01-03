package com.project.features.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Send
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.project.core.essentials.LoadResult
import com.project.core.essentials.entities.ImageSource
import com.project.core.theme.components.ImageView
import com.project.core.theme.previews.PreviewScreenContent


@Composable
fun MainScreen(
) {

    val viewModel: MainViewModel = hiltViewModel()

    val state by viewModel.uiState.collectAsStateWithLifecycle()
    MainContent(
        uiState = state,
        onGenerateClick = {
            viewModel.onGenerateSticker()
        },
        onTextChanged = {
            viewModel.onTextChanged(it)
        }
    )
}

@Composable
fun MainContent(
    uiState: MainUiState,
    onGenerateClick: () -> Unit,
    onTextChanged: (String) -> Unit,
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        if (uiState.shouldShowWelcomeItem) {
            WelcomeItem()
        }

        when (val sticker = uiState.stickerStatus) {
            LoadResult.Loading -> {

            }

            is LoadResult.Success -> {
                ImageView(
                    imageSources = ImageSource.Local(sticker.data.localPath),
                    modifier = Modifier.size(200.dp)
                )
            }

            is LoadResult.Error -> {

            }
        }

        ChatTextField(
            value = uiState.textInputState.text,
            onValueChange = onTextChanged,
            isTrailingIconEnabled = uiState.textInputState.isTrailingIconEnabled,
            onGenerateClick = onGenerateClick,
            isError = uiState.textInputState.isError,
            errorTextFieldMessage = uiState.textInputState.errorMessage,
            isEnabled = uiState.textInputState.isEnabled
        )
    }
}

@Composable
fun WelcomeItem(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.size(width = 300.dp, height = 180.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(18.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Text(
                text = "Hello!",
                fontSize = 18.sp
            )
            Text(
                text = "  Here you can generate any sticker simply by describing it. Write your first request to generate a sticker.\n" +
                        "Example:\n \"Cute emoji sticker of smiling face with hearts, big eyes\"",
                modifier = Modifier.padding(start = 8.dp, end = 8.dp, bottom = 8.dp),
                color = Color.Black
            )
        }

    }
}

@Composable
fun ChatTextField(
    value: String,
    isTrailingIconEnabled: Boolean,
    modifier: Modifier = Modifier,
    onGenerateClick: () -> Unit,
    isError: Boolean,
    errorTextFieldMessage: String?,
    onValueChange: (String) -> Unit,
    isEnabled: Boolean
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            enabled = isEnabled,
            shape = RoundedCornerShape(16.dp),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = colorResource(R.color.light_gray),
                focusedContainerColor = Color.White,
                errorCursorColor = Color.Red,
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
                disabledBorderColor = Color.Transparent,
                errorBorderColor = Color.Transparent
            ),
            trailingIcon = if (isTrailingIconEnabled) {
                {
                    Icon(
                        imageVector = Icons.Outlined.Send,
                        contentDescription = null,
                        modifier = Modifier.clickable { onGenerateClick() }
                    )
                }
            } else null,
            isError = isError,

            modifier = modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        if (isError) {
            Text(
                text = errorTextFieldMessage ?: "",
                color = Color.Red,
                fontSize = 12.sp
            )
        }
    }

}

@Preview(showSystemUi = true)
@Composable
private fun ChatTextFieldPreview() {
    PreviewScreenContent {
        ChatTextField(
            isTrailingIconEnabled = true,
            onGenerateClick = {},
            isError = false,
            errorTextFieldMessage = null,
            value = "",
            onValueChange = {},
            isEnabled = false
        )
    }
}

@Preview(showSystemUi = true)
@Composable
private fun WelcomeItemPreview() {
    PreviewScreenContent {
        WelcomeItem()
    }
}

//@Preview(showSystemUi = true)
//@Composable
//private fun MainContentPreview() {
//    PreviewScreenContent {
//        MainContent(
//            shouldShowWelcomeItem = true
//        )
//    }
//}