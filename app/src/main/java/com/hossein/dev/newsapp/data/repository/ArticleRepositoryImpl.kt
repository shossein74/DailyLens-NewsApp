package com.hossein.dev.newsapp.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.hossein.dev.newsapp.data.remote.NewsApis
import com.hossein.dev.newsapp.data.remote.ArticlePagingSource
import com.hossein.dev.newsapp.domain.model.Article
import com.hossein.dev.newsapp.domain.repository.ArticleRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ArticleRepositoryImpl @Inject constructor(
    private val apis: NewsApis
): ArticleRepository {

    override fun getArticles(sources: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 15),
            pagingSourceFactory = {
                ArticlePagingSource(apis, sources.joinToString { "," })
            }
        ).flow
    }
}