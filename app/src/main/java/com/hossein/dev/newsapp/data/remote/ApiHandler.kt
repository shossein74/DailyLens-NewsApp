package com.hossein.dev.newsapp.data.remote

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

object ApiHandler {

    suspend fun <T> invoke(
        dispatcher: CoroutineDispatcher = Dispatchers.IO,
        apiFunc: suspend () -> Response<T>,
    ): ApiResult<T> {
        return withContext(dispatcher) {
            return@withContext try {
                val apiResponse = apiFunc.invoke()

                when {
                    apiResponse.isSuccessful && apiResponse.body() != null -> {
                        ApiResult.Success(apiResponse.body()!!)
                    }

                    else -> {
                        val responseJson =
                            apiResponse.errorBody()?.source()?.readByteArray()?.decodeToString()
                                ?: apiResponse.message() ?: ""

                        ApiResult.Failed(apiResponse.code(), responseJson)
                    }
                }
            } catch (e: Exception) {
                ApiResult.Failed(400, e.message)
            }
        }
    }
}

sealed class ApiResult<T> {
    data class Success<T>(val result: T) : ApiResult<T>()
    data class Failed<T>(val statusCode: Int, val errorMessage: String?) : ApiResult<T>() {

        override fun toString(): String {
            return "$statusCode:${errorMessage ?: ""}"
        }

        companion object {
            fun <T> decode(value: String): Failed<T>? {
                if (!value.contains(":")) return null
                val splitList = value.split(":", limit = 1)
                val statusCode = splitList[0].toIntOrNull() ?: return null
                return Failed(statusCode, splitList[1])
            }
        }
    }
}