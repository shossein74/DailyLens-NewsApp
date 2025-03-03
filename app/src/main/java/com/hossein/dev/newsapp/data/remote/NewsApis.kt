package com.hossein.dev.newsapp.data.remote

import com.hossein.dev.newsapp.data.remote.dto.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApis {

    @GET("everything")
    suspend fun getNews(
        @Query("page") page: Int,
        @Query("q") sources: String,
        @Query("pageSize") pageSize: Int,
    ): Response<NewsResponse>
}