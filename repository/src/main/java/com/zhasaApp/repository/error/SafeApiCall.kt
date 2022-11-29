package com.zhasaApp.repository.error

import com.zhasaApp.repository.result.RequestResult
import retrofit2.Response

internal suspend fun <T> safeApiCall(apiCall: suspend () -> Response<T>): RequestResult<T> {
    return try {
        val result = apiCall.invoke()
        if (result.isSuccessful) {
            RequestResult.Success(apiCall.invoke())
        }
        RequestResult.Error(result.message())
    } catch (throwable: Throwable) {
        RequestResult.Error(throwable.message.orEmpty())
    }
}

