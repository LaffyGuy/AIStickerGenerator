package com.project.features.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Send
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.project.core.theme.previews.PreviewScreenContent


@Composable
fun MainScreen(
) {
    MainContent(
        shouldShowWelcomeItem = true
    )
}

@Composable
fun MainContent(
    shouldShowWelcomeItem: Boolean
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primaryContainer)
    ) {
        if (shouldShowWelcomeItem) {
            WelcomeItem(
                modifier = Modifier
                    .align(Alignment.Center)
                    .offset(y = (-50).dp)
            )
        }

        ChatTextField(
            modifier = Modifier.align(Alignment.BottomCenter),
            isTrailingIconEnabled = true
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
                fontSize = 18.sp)
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
    isTrailingIconEnabled: Boolean,
    modifier: Modifier = Modifier,
    onGenerateClick: () -> Unit,
    isError: Boolean,
    errorTextField: Boolean,
    errorTextFieldMessage: String?
) {

    var value by remember { mutableStateOf("Write request here!") }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = value,
            onValueChange = {
                value = it
            },
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
                        contentDescription = null
                    )
                }
            } else null,
            isError = isError,

            modifier = modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        if(isError) {
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
            errorTextField = false,
            errorTextFieldMessage = null
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

@Preview(showSystemUi = true)
@Composable
private fun MainContentPreview() {
    PreviewScreenContent {
        MainContent(
            shouldShowWelcomeItem = true
        )
    }
}