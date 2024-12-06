package com.vertonepa.noticias.most_popular.data

import com.vertonepa.noticias.most_popular.data.mappers.toDomain
import com.vertonepa.noticias.most_popular.domain.repository.MostPopularRepository
import com.vertonepa.noticias.most_popular.data.dto.most_popular.PopularArticles
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class MostPopularRepositoryImpl @Inject constructor(
    private val mostPopularProvider: MostPopularProvider
) : MostPopularRepository {
    override fun getPopularArticles(byCategory: String): PopularArticles = flow {
        val response = mostPopularProvider.mostPopularLastSevenDays(byCategory).results.map { it.toDomain() }
        emit(response)
    }.onStart {
        emit(emptyList())
    }


}