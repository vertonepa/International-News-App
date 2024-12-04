package com.vertonepa.noticias.most_popular.presentation

import com.vertonepa.noticias.most_popular.domain.models.MostPopularModel

data class MostPopularState(
    val sharedNews: List<MostPopularModel> = emptyList()
)