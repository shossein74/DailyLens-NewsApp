package com.hossein.dev.newsapp.presentation.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.hossein.dev.newsapp.domain.usecases.news.ArticleUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val articleUseCases: ArticleUseCases
): ViewModel() {

    var state = mutableStateOf(HomeState())
        private set

    val articles = articleUseCases.getArticles(
        sources = listOf()
    ).cachedIn(viewModelScope)
}