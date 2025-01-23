package com.hossein.dev.newsapp.presentation.onboarding.components

import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hossein.dev.newsapp.presentation.common.HButton
import com.hossein.dev.newsapp.presentation.common.HTextButton
import com.hossein.dev.newsapp.presentation.common.WormIndicator
import com.hossein.dev.newsapp.presentation.onboarding.onboardingPages
import com.hossein.dev.newsapp.ui.theme.NewsAppTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen(
    event: (OnBoardingEvent) -> Unit,
    modifier: Modifier = Modifier,
) {
    val pagerState = rememberPagerState(initialPage = 0) {
        onboardingPages.size
    }

    /*val buttonState = remember {
        derivedStateOf {
            when (pagerState.currentPage) {
                0 -> listOf("", "Next")
                1 -> listOf("Back", "Next")
                2 -> listOf("Back", "Get Started")
                else -> listOf("", "")
            }
        }
    }*/


    Box(
        modifier = modifier.fillMaxSize(),
        //verticalArrangement = Arrangement.SpaceBetween
    ) {
        Box(modifier = Modifier.fillMaxHeight(fraction = 1f)) {
            HorizontalPager(
                state = pagerState,
                pageSize = PageSize.Fill,
                verticalAlignment = Alignment.Top
            ) { index ->
                OnBoardingPage(page = onboardingPages[index])
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(alignment = Alignment.BottomCenter)
        ) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
                    .padding(bottom = 24.dp)
                    .navigationBarsPadding(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                WormIndicator(
                    count = onboardingPages.size,
                    pagerState = pagerState,
                    size = 11.dp,
                    spacing = 6.dp
                )

                Spacer(modifier = Modifier.weight(1f))

                ActionButtons(pagerState = pagerState, totalPages = onboardingPages.size, event)
            }
        }
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun ActionButtons(pagerState: PagerState, totalPages: Int, event: (OnBoardingEvent) -> Unit) {
    val scope = rememberCoroutineScope()

    val isFirstPage = pagerState.currentPage == 0
    val isLastPage = pagerState.currentPage == (totalPages - 1)

    if (!isFirstPage) {
        HTextButton(buttonText = "Back") {
            scope.launch {
                pagerState.animateScrollToPage(
                    pagerState.currentPage - 1,
                    animationSpec = tween(durationMillis = 300)
                )
            }
        }
        Spacer(modifier = Modifier.width(4.dp))
    }
    HButton(buttonText = if (isLastPage) "Get Started" else "Next") {
        if (!isLastPage) {
            scope.launch {
                pagerState.animateScrollToPage(
                    pagerState.currentPage + 1,
                    animationSpec = tween(durationMillis = 300)
                )
            }
        } else {
            event(OnBoardingEvent.SaveAppEntry)
        }
    }
}

@Preview
@Composable
private fun OnBoardingScreenPreview() {
    NewsAppTheme {
        OnBoardingScreen(event = {})
    }
}