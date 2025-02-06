package com.hossein.dev.newsapp.presentation.common

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.hossein.dev.newsapp.ui.theme.LocalCustomColorsPalette

@Composable
fun PageIndicator(
    modifier: Modifier = Modifier,
    pageSize: Int,
    selectedPage: Int,
    indicatorSize: Int = 8,
    selectedColor: Color = MaterialTheme.colorScheme.primary,
    unselectedColor: Color = LocalCustomColorsPalette.current.colorGrey300
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        repeat(pageSize) { page ->
            if (page != 0) {
                Spacer(modifier = Modifier.width(4.dp))
            }
            Box(
                modifier = Modifier
                    .size(indicatorSize.dp)
                    .clip(CircleShape)
                    .background(color = if (page == selectedPage) selectedColor else unselectedColor)
            ) {

            }
        }
    }
}

private fun Modifier.wormTransition(
    pagerState: PagerState,
    color: Color,
    spacing: Dp
) = drawBehind {
    val distance = size.width + spacing.roundToPx()
    val scrollPosition = pagerState.currentPage + pagerState.currentPageOffsetFraction
    val wormOffset = (scrollPosition % 1.0f) * 2f

    val xPos = scrollPosition.toInt() * distance
    val head = xPos + distance * 0f.coerceAtLeast(wormOffset - 1)
    val trail = xPos + size.width + 1f.coerceAtMost(wormOffset) * distance

    val worm = RoundRect(
        head, 0f, trail, size.height, CornerRadius(50f)
    )

    val path = Path().apply { addRoundRect(worm) }
    drawPath(path = path, color = color)
}

@Composable
fun WormIndicator(
    count: Int,
    pagerState: PagerState,
    modifier: Modifier = Modifier,
    size: Dp = 8.dp,
    color: Color = MaterialTheme.colorScheme.primary,
    unselectedColor: Color = MaterialTheme.colorScheme.primary.copy(alpha = 0.4f),
    spacing: Dp = 8.dp
) {
    Box(modifier = modifier, contentAlignment = Alignment.CenterStart) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(spacing),
            modifier = modifier.height(48.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            repeat(count) {
                Box(
                    modifier = Modifier
                        .size(size)
                        .background(color = if (pagerState.currentPage == it) color else unselectedColor, shape = CircleShape)
                )
            }
        }
        Box(
            modifier = Modifier
                .wormTransition(pagerState, color, spacing)
                .size(size)
        )
    }
}