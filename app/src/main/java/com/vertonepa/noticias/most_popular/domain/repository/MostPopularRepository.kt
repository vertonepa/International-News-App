package com.vertonepa.noticias.most_popular.domain.repository

import com.vertonepa.noticias.most_popular.data.dto.most_popular.PopularArticles

interface MostPopularRepository {
    fun getPopularArticles(byTrending: String): PopularArticles
}