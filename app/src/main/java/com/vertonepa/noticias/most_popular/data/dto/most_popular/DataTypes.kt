package com.vertonepa.noticias.most_popular.data.dto.most_popular

import com.vertonepa.noticias.most_popular.domain.models.MostPopularModel
import kotlinx.coroutines.flow.Flow

typealias Shared = Flow<List<MostPopularModel>>