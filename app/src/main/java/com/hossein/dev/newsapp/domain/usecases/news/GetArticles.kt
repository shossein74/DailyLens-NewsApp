package com.hossein.dev.newsapp.domain.usecases.news

import androidx.paging.PagingData
import com.hossein.dev.newsapp.domain.model.Article
import com.hossein.dev.newsapp.domain.repository.ArticleRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetArticlesUseCase @Inject constructor(
    private val articleRepository: ArticleRepository
) {

    operator fun invoke(sources: List<String>): Flow<PagingData<Article>> {
        return articleRepository.getArticles(sources)
    }
}