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
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class PromptsViewModel @Inject constructor(
    private val promptsSampleUseCase: PromptsSampleUseCase,
    val exceptionToMessageMapper: ExceptionToMessageMapper,
): ViewModel() {


    val promptsSampleFlow: StateFlow<LoadResult<List<PromptSample>>>
    = promptsSampleUseCase.getPromptsSample()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(1000),
            initialValue = LoadResult.Loading
        )

}