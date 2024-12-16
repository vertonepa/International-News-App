package com.vertonepa.noticias.most_popular.presentation

enum class Trending(val trend: String) {
    SHARED("Shared"),
    VIEWED("Viewed"),
    EMAILED("Emailed");

    companion object {
        fun trendingList() = entries.map { it.trend }
    }
}