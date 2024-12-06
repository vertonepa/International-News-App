package com.vertonepa.noticias.most_popular.presentation

import com.vertonepa.noticias.most_popular.domain.models.MostPopularModel

data class MostPopularState(
    val articlesList: List<MostPopularModel> = emptyList(),
    val currentCategory: String = "shared"
)