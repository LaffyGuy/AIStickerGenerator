package com.project.core.theme.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.project.core.essentials.LoadResult
import com.project.core.essentials.exceptions.EmptyExceptionToMessageMapper
import com.project.core.essentials.exceptions.ExceptionToMessageMapper
import com.project.core.theme.Dimens
import com.project.core.theme.MediumVerticalSpace
import com.project.core.theme.R

@Composable
fun <T> LoadResultView(
    loadResult: LoadResult<T>,
    content: @Composable (T) -> Unit,
    onTryAgainAction: () -> Unit,
    modifier: Modifier = Modifier,
    exceptionToMessageMapper: ExceptionToMessageMapper
) {
    Box(modifier = modifier) {
        when (loadResult) {
            LoadResult.Loading -> {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
            is LoadResult.Success -> content(loadResult.data)
            is LoadResult.Error -> {
                val message = exceptionToMessageMapper.getLocalizedMessage(loadResult.exception)
                Column(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(Dimens.MediumPadding)
                    ,
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = message,
                        textAlign = TextAlign.Center
                    )
                    MediumVerticalSpace()
                    Button(
                        onClick = onTryAgainAction
                    ) {
                        Text(text = stringResource(R.string.try_again))
                    }
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun SuccessContainerView() {
    LoadResultView<String>(
        loadResult = LoadResult.Loading,
        content = {
            Text(text = "Data loaded: $it")
        },
        onTryAgainAction = {},
        exceptionToMessageMapper = EmptyExceptionToMessageMapper()
    )
}