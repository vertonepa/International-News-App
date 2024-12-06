package com.vertonepa.noticias.most_popular.data

import com.vertonepa.noticias.most_popular.data.dto.most_popular.MostPopularResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface MostPopularProvider {

    @GET("mostpopular/v2/{category}/7.json")
    suspend fun mostPopularLastSevenDays(
        @Path("category") category: String
    ): MostPopularResponse

}