package com.vertonepa.noticias.most_popular.presentation

sealed interface MostPopularEvent {
    data class OnCategoryChanged(val trending: String): MostPopularEvent
}