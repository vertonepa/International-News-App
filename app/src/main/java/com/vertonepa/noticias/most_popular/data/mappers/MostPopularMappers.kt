package com.vertonepa.noticias.most_popular.data.mappers

import com.vertonepa.noticias.most_popular.data.dto.most_popular.MostPopularDto
import com.vertonepa.noticias.most_popular.domain.models.MostPopularModel
import java.time.LocalDate


fun MostPopularDto.toDomain(): MostPopularModel {
    return MostPopularModel(
        id = this.id,
        webUrl = this.url,
        title = this.title,
        section = this.section,
        publishedDate = LocalDate.parse(this.publishedDate),
        pic = this.media.firstOrNull()?.mediaMetadata?.firstOrNull()?.url
    )
}