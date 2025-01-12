package com.hossein.dev.newsapp.presentation.onboarding.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextMotion
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import com.hossein.dev.newsapp.ui.theme.NewsAppTheme
import com.hossein.dev.newsapp.ui.theme.Typography
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

@Composable
fun SplashPage() {
    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it.calculateTopPadding())
                .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.1F)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                buildAnnotatedString {
                    withStyle(ParagraphStyle(textMotion = TextMotion.Animated)) {
                        append("Hossein")
                    }
                    withStyle(SpanStyle(fontSize = TextUnit(30f, TextUnitType.Sp), fontWeight = FontWeight.Thin)) {
                        append("News App")
                    }
                },
                style = Typography.displayLarge.copy(
                    fontSize = TextUnit(46F, TextUnitType.Sp),
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Center
                ),
                color = MaterialTheme.colorScheme.primary,
            )
        }
    }
}


@Preview()
@Composable
fun SplashPagePreview() {
    NewsAppTheme {
        SplashPage()
    }
}