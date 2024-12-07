package com.vertonepa.noticias.most_popular.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.vertonepa.noticias.most_popular.domain.models.MostPopularModel
import com.vertonepa.noticias.most_popular.presentation.components.CategoriesTabRow
import com.vertonepa.noticias.most_popular.presentation.components.MostPopularCard
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun MostPopularScreen(viewModel: MostPopularViewModel = hiltViewModel()) {
    val state = viewModel.state

    MostPopularScreen(state = state, onEvent = { event -> viewModel.onEvent(event) })
}


@Composable
fun MostPopularScreen(state: MostPopularState, onEvent: (MostPopularEvent) -> Unit) {
    val pagerState = rememberPagerState { state.categories.size }
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(key1 = pagerState) {
        snapshotFlow { pagerState.currentPage }.collect { page ->
            onEvent(MostPopularEvent.OnCategoryChanged(category = state.categories[page]))
        }
    }

    Scaffold(Modifier.fillMaxSize()) { scaffoldPadding ->
        Column(modifier = Modifier.padding(scaffoldPadding)) {
            CategoriesTabRow(pagerState = pagerState, categories = state.categories) { index ->
                coroutineScope.launch { pagerState.animateScrollToPage(index) }
            }
            HorizontalPager(state = pagerState) {
                LazyColumn {
                    items(state.articlesList) { getArticle ->
                        MostPopularCard(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 1.dp),
                            article = getArticle
                        )
                    }
                }
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
        onEvent = {},
        state = MostPopularState(
            listOf(
                MostPopularModel(
                    title = title, publishedDate = currentDate, section = section, imgUrl = img
                ), MostPopularModel(
                    title = title, publishedDate = currentDate, section = section, imgUrl = img
                ), MostPopularModel(
                    title = title, publishedDate = currentDate, section = section, imgUrl = img
                )
            )
        )
    )
}