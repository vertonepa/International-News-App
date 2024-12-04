package com.vertonepa.noticias.most_popular.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vertonepa.noticias.most_popular.domain.usecases.GetMostSharedOrderByDateUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MostPopularViewModel @Inject constructor(
    private val getMostSharedOrderByDateUseCase: GetMostSharedOrderByDateUseCase
) : ViewModel() {

    var state by mutableStateOf(MostPopularState())
        private set

    init {
        getMostSharedArticles()
    }

    private fun getMostSharedArticles() {
        viewModelScope.launch {
            getMostSharedOrderByDateUseCase().collectLatest {
                state = state.copy(sharedNews = it)
            }
        }
    }
}