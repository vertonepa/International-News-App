package com.vertonepa.noticias.most_popular.data.mappers

import com.vertonepa.noticias.most_popular.data.dto.most_popular.MostPopularDto
import com.vertonepa.noticias.most_popular.domain.models.MostPopularModel
import java.time.LocalDate
import java.time.format.DateTimeFormatter


fun MostPopularDto.toDomain(): MostPopularModel {
    return MostPopularModel(
        id = this.id,
        webUrl = this.url,
        title = this.title,
        section = this.section,
        publishedDate = LocalDate.parse(this.publishedDate).format(DateTimeFormatter.ofPattern("dd MMMM yyyy")),
        imgUrl = this.media.firstOrNull()?.mediaMetadata?.firstOrNull()?.url
    )
}