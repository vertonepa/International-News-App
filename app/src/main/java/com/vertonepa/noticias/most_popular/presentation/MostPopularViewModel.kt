package com.vertonepa.noticias.most_popular.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vertonepa.noticias.most_popular.domain.usecases.GetPopularArticlesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MostPopularViewModel @Inject constructor(
    private val getPopularArticlesUseCase: GetPopularArticlesUseCase
) : ViewModel() {

    var state by mutableStateOf(MostPopularState())
        private set

    init {
        getMostPopularArticles(byTrending = state.selectedTrending.lowercase())
    }

    private fun getMostPopularArticles(byTrending: String) {
        viewModelScope.launch {
            getPopularArticlesUseCase(byTrending).collectLatest {
                state = state.copy(articlesList = it)
            }
        }
    }

    fun onEvent(event: MostPopularEvent) {
        when(event) {
            is MostPopularEvent.OnCategoryChanged -> {
                state = state.copy(selectedTrending = event.trending)
                getMostPopularArticles(byTrending = state.selectedTrending)
            }
        }
    }
}