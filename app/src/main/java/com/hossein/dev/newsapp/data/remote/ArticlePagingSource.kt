package com.hossein.dev.newsapp.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.hossein.dev.newsapp.domain.model.Article

class ArticlePagingSource(
    private val newsApis: NewsApis,
    private val sources: String
) : PagingSource<Int, Article>() {
    private var totalFetchedCount = 0
    private var pageSize = 15

    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        val page = params.key ?: 1

        return try {
            val newsResponse = ApiHandler.invoke {
                newsApis.getNews(page = page, sources = sources, pageSize = pageSize)
            }

            when (newsResponse) {
                is ApiResult.Success -> {
                    totalFetchedCount += newsResponse.result.articles.size
                    LoadResult.Page(
                        data = newsResponse.result.articles,
                        prevKey = if (page == 1) null else page - 1,
                        nextKey = if (totalFetchedCount == newsResponse.result.totalResults) null else page + 1
                    )
                }

                is ApiResult.Failed -> {
                    LoadResult.Error(Exception(newsResponse.toString()))
                }
            }

        } catch (e: Exception) {
            LoadResult.Error(
                throwable = e
            )
        }
    }
}