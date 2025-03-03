package com.hossein.dev.newsapp.presentation.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.LoadState
import androidx.paging.cachedIn
import androidx.paging.compose.LazyPagingItems
import com.hossein.dev.newsapp.data.remote.ArticlePagingState
import com.hossein.dev.newsapp.domain.model.Article
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
        sources = listOf("Android")
    ).cachedIn(viewModelScope)

    fun getArticlePagingState(items: LazyPagingItems<Article>): ArticlePagingState {
        return when {
            items.loadState.refresh is LoadState.Loading -> ArticlePagingState.Loading

            items.loadState.refresh is LoadState.Error -> {
                val error = (items.loadState.refresh as LoadState.Error).error

                ArticlePagingState.Failure(error)
            }

            items.loadState.append is LoadState.Loading -> ArticlePagingState.LoadingMore(items)

            items.loadState.append is LoadState.Error -> {
                val error = (items.loadState.append as LoadState.Error).error

                ArticlePagingState.FailureMore(items, error)
            }

            else -> ArticlePagingState.Success(articles = items)
        }
    }
}