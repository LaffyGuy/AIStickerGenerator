package com.project.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.core.essentials.LoadResult
import com.project.domain.GetKeyFeatureUseCase
import com.project.domain.entities.KeyFeature
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class InitViewModel @Inject constructor(
    private val getKeyFeatureUseKeys: GetKeyFeatureUseCase,
) : ViewModel() {

    val stateFlow: StateFlow<LoadResult<State>> = getKeyFeatureUseKeys
        .invoke()
        .map { loadResult ->
            when (loadResult) {
                LoadResult.Loading -> LoadResult.Loading
                is LoadResult.Success -> {
                    val loadResult1 = loadResult.data
                    LoadResult.Success(State(keyFeature = loadResult1, isCheckAuthInProgress = false))
                }
                is LoadResult.Error -> LoadResult.Error(loadResult.exception)
            }
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(1000),
            initialValue = LoadResult.Loading
        )

    fun letsGo() {

    }

}


data class State(
    val keyFeature: KeyFeature,
    val isCheckAuthInProgress: Boolean
)