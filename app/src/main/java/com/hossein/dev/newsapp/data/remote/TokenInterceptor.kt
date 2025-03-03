package com.hossein.dev.newsapp.data.remote

import okhttp3.Interceptor
import okhttp3.Response

class TokenInterceptor : Interceptor {
    private val token = "fd0084adb1dc4adc8ea23924601f8238"

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
        request.addHeader("Authorization", token)
        return chain.proceed(request.build())
    }

}