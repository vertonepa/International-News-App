package com.vertonepa.noticias.most_popular.domain.usecases

import com.vertonepa.noticias.most_popular.data.dto.most_popular.PopularArticles
import com.vertonepa.noticias.most_popular.domain.repository.MostPopularRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetPopularArticlesUseCase @Inject constructor(
    private val repository: MostPopularRepository
) {
    operator fun invoke(byTrending: String): PopularArticles =
        repository.getPopularArticles(byTrending).map { articles ->
            withContext(Dispatchers.Default) {
                articles.sortedByDescending { it.publishedDate }
            }
        }
}