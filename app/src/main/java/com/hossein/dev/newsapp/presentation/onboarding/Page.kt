package com.hossein.dev.newsapp.presentation.onboarding

import androidx.annotation.DrawableRes
import com.hossein.dev.newsapp.R

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int
)

val onboardingPages  = listOf(
    Page(
        title = "1. First title",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
        image = R.drawable.onboarding_img1
    ),
    Page(
        title = "2. Second title",
        description = "Lorem ipsum dolor sit amet. Qui natus minus id inventore blanditiis est saepe laudantium non nihil error.",
        image = R.drawable.onboarding_img2
    ),
    Page(
        title = "3. Third title",
        description = "Lorem ipsum dolor sit amet. Id distinctio exercitationem 33 accusantium impedit qui totam blanditiis.",
        image = R.drawable.onboarding_img3
    )
)
