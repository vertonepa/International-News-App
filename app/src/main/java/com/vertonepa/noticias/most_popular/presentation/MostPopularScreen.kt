package com.vertonepa.noticias.most_popular.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.vertonepa.noticias.most_popular.domain.models.MostPopularModel
import com.vertonepa.noticias.most_popular.presentation.components.MostPopularCard
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun MostPopularScreen(viewModel: MostPopularViewModel = hiltViewModel()) {
    val state = viewModel.state
    MostPopularScreen(state = state)
}


@Composable
fun MostPopularScreen(state: MostPopularState) {
    val mostShared = state.articlesList

    Scaffold(Modifier.fillMaxSize()) { scaffoldPadding ->
        scaffoldPadding.calculateTopPadding()


        LazyColumn {
            items(mostShared) { get ->
                MostPopularCard(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 4.dp, vertical = 1.dp),
                    title = get.title,
                    section = get.section,
                    date = get.publishedDate,
                    imgUrl = get.pic.orEmpty(),
                    webUrl = get.webUrl
                )
            }
        }
    }
}


@Preview
@Composable
private fun Preview() {
    val title = "TITLE!!"
    val section = "Section"
    val currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMMM yyyy"))
    val img = "https://via.placeholder.com/150"

    MostPopularScreen(
        state = MostPopularState(
            listOf(
                MostPopularModel(
                    title = title, publishedDate = currentDate, section = section, pic = img
                ), MostPopularModel(
                    title = title, publishedDate = currentDate, section = section, pic = img
                ), MostPopularModel(
                    title = title, publishedDate = currentDate, section = section, pic = img
                )
            )
        )
    )
}