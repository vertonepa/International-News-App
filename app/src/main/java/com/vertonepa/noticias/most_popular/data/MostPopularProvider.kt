package com.vertonepa.noticias.most_popular.data

import com.vertonepa.noticias.most_popular.data.dto.most_popular.MostPopularResponse
import retrofit2.http.GET

interface MostPopularProvider {

    @GET("mostpopular/v2/shared/7.json")
    suspend fun mostSharedLastSevenDays(): MostPopularResponse

}