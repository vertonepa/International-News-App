package com.vertonepa.noticias.most_popular.presentation

import com.vertonepa.noticias.most_popular.domain.models.MostPopularModel

data class MostPopularState(
    val articlesList: List<MostPopularModel> = emptyList(),
    val trending: List<String> = Trending.trendingList(),
    val selectedTrending: String = Trending.SHARED.trend
)