package com.vertonepa.noticias.most_popular.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CategoriesTabRow(
    pagerState: PagerState,
    categories: List<String>,
    onTabSelected: (Int) -> Unit
) {
    ScrollableTabRow(selectedTabIndex = pagerState.currentPage, edgePadding = 0.dp) {
        categories.forEachIndexed { index, category ->
            Tab(
                selected = pagerState.currentPage == index,
                onClick = { onTabSelected(index) },
            ) {
                Text(text = category, modifier = Modifier.padding(vertical = 8.dp))
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    val pagerState = rememberPagerState { 3 }
    val list = listOf("shared", "viewed", "emailed")
    CategoriesTabRow(pagerState = pagerState, categories = list) { list.size }
}