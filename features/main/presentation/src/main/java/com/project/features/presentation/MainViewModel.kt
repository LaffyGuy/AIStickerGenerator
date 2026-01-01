package com.project.features.presentation

import androidx.compose.ui.graphics.ImageBitmap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.core.essentials.LoadResult
import com.project.features.domain.GenerateStickerUseCase
import com.project.features.domain.entities.GeneratedImage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val generateStickerUseCase: GenerateStickerUseCase
) : ViewModel() {

    private val _inputState = MutableStateFlow(TextInputUiState())
    val inputState: StateFlow<TextInputUiState> = _inputState

    private val _stickerState = MutableStateFlow<LoadResult<GeneratedImage>>(LoadResult.Loading)
    val stickerState: StateFlow<LoadResult<GeneratedImage>> = _stickerState

    val uiState = combine(
        _inputState,
        _stickerState
    ) { input, sticker ->
        MainUiState(
            textInputState = input,
            stickerStatus = sticker,
            shouldShowWelcomeItem = sticker !is LoadResult.Loading && sticker !is LoadResult.Success
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 1000),
        initialValue = MainUiState()
    )

    fun onTextChanged(input: String) {
        _inputState.update { it.copy(text = input) }
    }

    fun onGenerateSticker() {
        val prompt = _inputState.value.text
        if(prompt.isBlank()) {
            _inputState.update { it.copy(isError = true, errorMessage = "Prompt cannot be empty") }
            return
        }

        _inputState.update { it.copy(isEnabled = false, isTrailingIconEnabled = false) }
        _stickerState.value = LoadResult.Loading

        viewModelScope.launch {
            try {
                val image = generateStickerUseCase(prompt)
                _stickerState.value = LoadResult.Success(image)
            } catch (e: Exception) {
                _stickerState.value = LoadResult.Error(e)
            }
        }
    }

}

//data class MainUiState(
//    val generatedImage: ImageBitmap? = null,
//    val shouldShowWelcomeItem: Boolean = true,
//    val shouldShowTrailingIcon: Boolean = false,
//    val textFieldValue: String? = null,
//    val errorTextField: Boolean = false,
//    val errorTextFieldMessage: String? = null
//)

data class MainUiState(
    val textInputState: TextInputUiState = TextInputUiState(),
    val stickerStatus: LoadResult<GeneratedImage> = LoadResult.Loading,
    val shouldShowWelcomeItem: Boolean = true,
)

data class TextInputUiState(
    val text: String = "",
    val isEnabled: Boolean = true,
    val isTrailingIconEnabled: Boolean = true,
    val isError: Boolean = false,
    val errorMessage: String? = null,
)