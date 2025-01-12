package com.hossein.dev.newsapp.presentation.onboarding.components

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hossein.dev.newsapp.presentation.onboarding.Page
import com.hossein.dev.newsapp.presentation.onboarding.onboardingPages
import com.hossein.dev.newsapp.ui.theme.NewsAppTheme

@Composable
fun OnBoardingPage(
    modifier: Modifier = Modifier,
    page: Page
) {
    Column(modifier = modifier.background(MaterialTheme.colorScheme.background)) {
        Image(
            modifier = Modifier
                .weight(0.65f),
            painter = painterResource(id = page.image),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .offset(y = (-28).dp)
                .weight(0.35f)
                .background(
                    MaterialTheme.colorScheme.background,
                    shape = RoundedCornerShape(topStartPercent = 8, topEndPercent = 8)
                ),
        ) {
            Column(modifier = Modifier.padding(top = 24.dp)) {
                Text(
                    text = page.title,
                    modifier = Modifier.padding(horizontal = 24.dp),
                    style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.Bold),
                    color = MaterialTheme.colorScheme.onBackground
                )
                Text(
                    text = page.description,
                    modifier = Modifier.padding(horizontal = 24.dp),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
        }

    }
}

@Preview()
@Composable
fun OnBoardingPagePreview() {
    NewsAppTheme {
        OnBoardingPage(
            page = onboardingPages[0]
        )
    }
}