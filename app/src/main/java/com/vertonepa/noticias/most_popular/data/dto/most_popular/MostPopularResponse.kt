package com.vertonepa.noticias.most_popular.data.dto.most_popular


import com.google.gson.annotations.SerializedName

data class MostPopularResponse(
    @SerializedName("copyright")
    val copyright: String,
    @SerializedName("num_results")
    val numResults: Int,
    @SerializedName("results")
    val results: List<MostPopularDto>,
    @SerializedName("status")
    val status: String
)