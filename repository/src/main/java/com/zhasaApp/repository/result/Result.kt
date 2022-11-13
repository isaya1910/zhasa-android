package com.zhasaApp.repository.result


sealed class RequestResult<out T> {
    data class Success<out T>(val data: T) : RequestResult<T>()
    data class Error(val error: String) : RequestResult<Nothing>()
}
