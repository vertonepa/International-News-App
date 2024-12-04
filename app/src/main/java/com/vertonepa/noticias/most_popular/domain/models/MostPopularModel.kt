package com.vertonepa.noticias.most_popular.domain.models

import java.time.LocalDate

data class MostPopularModel(
    val id: Long = 0,
    val webUrl: String = "",
    val section: String,
    val title: String,
    val publishedDate: LocalDate,
    val pic: String?
)
