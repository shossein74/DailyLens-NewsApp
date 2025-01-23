package com.hossein.dev.newsapp.presentation.onboarding.components

sealed class OnBoardingEvent {

    data object SaveAppEntry: OnBoardingEvent()
}