package com.hossein.dev.newsapp.presentation.home.article

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.hossein.dev.newsapp.domain.model.Article
import com.hossein.dev.newsapp.domain.model.Source
import com.hossein.dev.newsapp.ui.theme.AppTheme

@Composable
fun ArticleItem(modifier: Modifier = Modifier, article: Article) {

    val context = LocalContext.current

    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(Color(0xFFEFEFEF), shape = MaterialTheme.shapes.medium)
            .padding(vertical = 12.dp, horizontal = 12.dp)
    ) {
        AsyncImage(
            modifier = Modifier
                .width(64.dp)
                .height(64.dp)
                .clip(MaterialTheme.shapes.medium),
            model = ImageRequest.Builder(context).data(article.urlToImage).build(),
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )
        Spacer(
            modifier = Modifier.width(12.dp)
        )

        Column() {
            Text(
                article.title,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface
            )
            Spacer(
                modifier = Modifier.height(12.dp)
            )
            Text(
                article.content,
                style = MaterialTheme.typography.bodySmall,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ArticleItemPreview() {
    AppTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            repeat(5) {
                ArticleItem(
                    article = Article(
                        author = "seyyed hossein talebi",
                        content = "This article about how use side effects in jetpack compose. and when we must use it",
                        description = "This is test description",
                        publishedAt = "2/18/2025 12:53 AM",
                        urlToImage = "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.istockphoto.com%2Fphotos%2Fbreaking-news&psig=AOvVaw1dpVB48pBQHmapmp6CuwE8&ust=1739957032172000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCMC0iprzzIsDFQAAAAAdAAAAABAE",
                        url = "",
                        title = "Side Effects in Jetpack Compose",
                        source = Source(id = "1", name = "AndroidProDev")
                    )
                )
            }
        }
    }
}