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
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun MostPopularCard(
    modifier: Modifier = Modifier,
    title: String,
    section: String,
    date: String,
    imgUrl: String,
    webUrl: String
) {
    val context = LocalContext.current
    Card(
        modifier = modifier,
        shape = RectangleShape,
        border = BorderStroke(color = Color.Black, width = 1.dp),
        onClick = {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(webUrl))
            context.startActivity(intent)
        }
    ) {
        Row(modifier = Modifier.padding(4.dp)) {
            SubcomposeAsyncImage(model = imgUrl,
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
                        model = imgUrl,
                        contentDescription = null
                    )
                }
            )

            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Row {
                    Text(text = section)
                    Spacer(modifier = Modifier.weight(1f))
                    Text(text = date)
                }

                Text(text = title, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            }
        }
    }
}


@Preview
@Composable
private fun Preview() {
    MostPopularCard(
        title = "Titulo 1",
        section = "Section",
        date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMMM yyyy")),
        imgUrl = "https://loremflickr.com/320/240",
        webUrl = ""
    )
}