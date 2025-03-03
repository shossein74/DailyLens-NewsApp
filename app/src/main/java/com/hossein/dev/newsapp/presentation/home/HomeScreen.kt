package com.hossein.dev.newsapp.presentation.home

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hossein.dev.newsapp.R
import com.hossein.dev.newsapp.data.remote.ArticlePagingState
import com.hossein.dev.newsapp.presentation.home.article.ArticleList
import com.hossein.dev.newsapp.util.defaultSize
import com.hossein.dev.newsapp.util.largeSize
import com.hossein.dev.newsapp.util.semiLargeSize
import com.hossein.dev.newsapp.util.smallSize

@Composable
fun HomeScreen(articles: ArticlePagingState, modifier: Modifier = Modifier) {

    Column(
        modifier = modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxSize()
            .padding(top = smallSize)
            .padding(horizontal = defaultSize)
            .statusBarsPadding()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo Image",
                modifier = Modifier
                    .width(semiLargeSize)
                    .height(largeSize),
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary, BlendMode.SrcIn)
            )

            Spacer(modifier = Modifier.width(smallSize))
            Text(
                text = "DailyLens",
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                ),
                color = MaterialTheme.colorScheme.primary
            )
        }

        Spacer(
            modifier = Modifier.height(defaultSize)
        )

        OutlinedTextField(
            "",
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            onValueChange = { value -> Log.v("Search text", value) },
            placeholder = {
                Text(
                    "Search news",
                    style = MaterialTheme.typography.bodySmall.copy(fontSize = 12.sp)
                )
            },
            leadingIcon = {
                Icon(
                    Icons.Rounded.Search,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSurface
                )
            },
            singleLine = true,
            shape = RoundedCornerShape(smallSize),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = MaterialTheme.colorScheme.background,
                focusedContainerColor = MaterialTheme.colorScheme.background,
            ),

            )

        Spacer(
            modifier = Modifier.height(defaultSize)
        )

        ArticleList(modifier = Modifier.fillMaxSize(), state = articles)
    }
}

/*@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    HomeScreen()
}*/

