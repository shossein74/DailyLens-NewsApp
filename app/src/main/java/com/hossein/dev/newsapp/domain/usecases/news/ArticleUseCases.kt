package com.hossein.dev.newsapp.domain.usecases.news

import javax.inject.Inject

data class ArticleUseCases @Inject constructor(
    val getArticles: GetArticlesUseCase
)