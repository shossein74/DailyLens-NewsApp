package com.hossein.dev.newsapp.data.remote.dto

import com.hossein.dev.newsapp.domain.model.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)