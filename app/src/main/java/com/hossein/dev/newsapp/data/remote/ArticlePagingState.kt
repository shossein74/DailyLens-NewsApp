package com.hossein.dev.newsapp.data.remote

import androidx.paging.compose.LazyPagingItems
import com.hossein.dev.newsapp.domain.model.Article

sealed class ArticlePagingState {

    data object Loading : ArticlePagingState()
    data class LoadingMore(val articles: LazyPagingItems<Article>) : ArticlePagingState()
    data class Success(val articles: LazyPagingItems<Article> ): ArticlePagingState()
    data class Failure(val error: Throwable) : ArticlePagingState()
    data class FailureMore(val articles: LazyPagingItems<Article>, val error: Throwable) : ArticlePagingState()
}