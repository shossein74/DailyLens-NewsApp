package com.hossein.dev.newsapp.domain.repository

import androidx.paging.PagingData
import com.hossein.dev.newsapp.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface ArticleRepository {

    fun getArticles(sources: List<String>): Flow<PagingData<Article>>
}