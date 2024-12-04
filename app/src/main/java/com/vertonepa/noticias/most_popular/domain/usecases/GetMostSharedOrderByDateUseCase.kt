package com.vertonepa.noticias.most_popular.domain.usecases

import com.vertonepa.noticias.most_popular.domain.repository.MostPopularRepository
import com.vertonepa.noticias.most_popular.data.dto.most_popular.Shared
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetMostSharedOrderByDateUseCase @Inject constructor(
    private val repository: MostPopularRepository
) {
    operator fun invoke(): Shared = repository.getMostShared().map { articles ->
        withContext(Dispatchers.Default) {
            articles.sortedByDescending { it.publishedDate }
        }
    }
}