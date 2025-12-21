package com.project.features.prompts.presentation.promptssample

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.core.essentials.LoadResult
import com.project.core.essentials.exceptions.ExceptionToMessageMapper
import com.project.features.prompts.domain.PromptsSampleUseCase
import com.project.features.prompts.domain.entities.PromptSample
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class PromptsViewModel @Inject constructor(
    private val promptsSampleUseCase: PromptsSampleUseCase,
    val exceptionToMessageMapper: ExceptionToMessageMapper,
): ViewModel() {

//    val uiState = promptsSampleUseCase.getPromptsSample()
//        .map { result ->
//            when(result) {
//                LoadResult.Loading -> PromptsUiState(isLoading = true)
//                is LoadResult.Success -> PromptsUiState(items = result.data)
//                is LoadResult.Error -> PromptsUiState(errorMessage = "Error")
//            }
//        }
//        .stateIn(
//            scope = viewModelScope,
//            started = SharingStarted.WhileSubscribed(1000),
//            initialValue = PromptsUiState()
//        )

    val promptsSampleFlow: StateFlow<LoadResult<List<PromptSample>>>
    = promptsSampleUseCase.getPromptsSample()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(1000),
            initialValue = LoadResult.Loading
        )

}

data class PromptsUiState(
    val items: List<PromptSample> = emptyList()
)