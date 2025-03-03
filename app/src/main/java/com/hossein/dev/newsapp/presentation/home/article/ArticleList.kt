package com.hossein.dev.newsapp.presentation.home.article

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.dp
import com.hossein.dev.newsapp.data.remote.ArticlePagingState
import com.hossein.dev.newsapp.util.EmptyScreen
import com.hossein.dev.newsapp.util.shimmerEffect

@Composable
fun ArticleList(modifier: Modifier = Modifier, state: ArticlePagingState) {

    when (state) {
        is ArticlePagingState.Loading -> {
            ArticleListShimmer()
        }

        is ArticlePagingState.Failure -> {
            EmptyScreen(text = "Something went wrong")
        }

        else-> {

            val articles = (state as? ArticlePagingState.Success)?.articles
                ?: (state as? ArticlePagingState.LoadingMore)?.articles
                ?: (state as? ArticlePagingState.FailureMore)?.articles

                if (articles == null) {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        EmptyScreen(text= "Empty")
                    }
                } else {
                    LazyColumn(
                        modifier = modifier,
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {

                        items(count = articles.itemCount) { index ->
                            articles[index]?.let { article ->
                                ArticleItem(article = article)
                            }
                        }

                        if (state is ArticlePagingState.LoadingMore) {
                            item {
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(86.dp)
                                        .background(Color.Yellow),
                                    contentAlignment = Alignment.Center
                                ) {
                                    CircularProgressIndicator(
                                        modifier = Modifier
                                            .width(42.dp)
                                            .height(42.dp),
                                        color = MaterialTheme.colorScheme.primary,
                                        strokeWidth = 2.dp,
                                        strokeCap = StrokeCap.Round,
                                    )
                                }
                            }
                        }

                        if (state is ArticlePagingState.FailureMore) {
                            item {
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(86.dp)
                                        .background(Color.Red),
                                    contentAlignment = Alignment.Center,
                                ) {
                                    EmptyScreen(text = state.error.message ?: "Failed to load more items")
                                }
                            }
                        }
                    }
                }
        }
    }
}

@Composable
fun ArticleListShimmer(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(84.dp)
            .padding(all = 16.dp)
            .background(Color(0xFFA1A1A1))
    ) {
        Box(
            modifier = Modifier
                .width(64.dp)
                .fillMaxHeight()
                .border(
                    shape = RoundedCornerShape(8.dp),
                    border = BorderStroke(0.dp, Color(0x00FFFFFF))
                )
                .shimmerEffect()
        )

        Spacer(modifier = Modifier.width(12.dp))

        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(28.dp)
                    .border(
                        shape = RoundedCornerShape(8.dp),
                        border = BorderStroke(0.dp, Color(0x00FFFFFF))
                    )
                    .shimmerEffect()
            )

            Spacer(modifier = Modifier.height(12.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(24.dp)
                    .border(
                        shape = RoundedCornerShape(8.dp),
                        border = BorderStroke(0.dp, Color(0x00FFFFFF))
                    )
                    .shimmerEffect()
            )
        }
    }

}
