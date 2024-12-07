package com.vertonepa.noticias.most_popular.presentation

import com.vertonepa.noticias.most_popular.domain.models.MostPopularModel

data class MostPopularState(
    val articlesList: List<MostPopularModel> = emptyList(),
    val categories: List<String> = listOf("shared", "viewed", "emailed"),
    val category: String = "shared"
)