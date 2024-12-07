package com.vertonepa.noticias.most_popular.domain.models

data class MostPopularModel(
    val id: Long = 0,
    val webUrl: String = "",
    val section: String,
    val title: String,
    val publishedDate: String,
    val imgUrl: String?
)
