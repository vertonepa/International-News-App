package com.vertonepa.noticias.most_popular.presentation.components

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import coil3.compose.SubcomposeAsyncImage
import com.vertonepa.noticias.core.presentation.ShimmerEffect
import com.vertonepa.noticias.most_popular.domain.models.MostPopularModel
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun MostPopularCard(
    modifier: Modifier = Modifier,
    article: MostPopularModel
) {
    val context = LocalContext.current
    Card(
        modifier = modifier,
        shape = RectangleShape,
        onClick = {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(article.webUrl))
            context.startActivity(intent)
        }
    ) {
        Row(modifier = Modifier.padding(4.dp)) {
            SubcomposeAsyncImage(model = article.imgUrl,
                contentDescription = null,
                modifier = Modifier
                    .size(75.dp)
                    .clip(shape = RoundedCornerShape(25f))
                    .align(alignment = Alignment.CenterVertically),
                loading = { ShimmerEffect() },
                error = {
                    AsyncImage(
                        model = "https://i.postimg.cc/wTHznG4S/image.jpg",
                        contentDescription = null
                    )
                },
                success = {
                    AsyncImage(
                        model = article.imgUrl,
                        contentDescription = null
                    )
                }
            )

            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Row {
                    Text(text = article.section)
                    Spacer(modifier = Modifier.weight(1f))
                    Text(text = article.publishedDate)
                }

                Text(text = article.title, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            }
        }
    }
}


@Preview
@Composable
private fun Preview() {
    MostPopularCard(
        article = MostPopularModel(
            title = "Título 1",
            section = "Section",
            publishedDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMMM yyyy")),
            imgUrl = ""
            )
        )
}