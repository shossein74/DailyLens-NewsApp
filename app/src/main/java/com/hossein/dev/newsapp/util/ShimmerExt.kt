package com.hossein.dev.newsapp.util

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color

fun Modifier.shimmerEffect(color: Color = Color(0xFF7E7E7E)) = composed {
    val transition = rememberInfiniteTransition()

    val alpha = transition.animateFloat(initialValue = 0.1F, targetValue = 0.9F, animationSpec = infiniteRepeatable(
        animation = tween(durationMillis = 1200),
        repeatMode = RepeatMode.Reverse,
    )).value

    background(color.copy(alpha = alpha))
}