package com.hepsihikaye.android.util

/**
 * A generic class that contains data and status about loading this data.
 * Used as a wrapper for data exposed via a LiveData or Flow.
 */
sealed class Resource<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T) : Resource<T>(data)
    class Loading<T>(data: T? = null) : Resource<T>(data)
    class Error<T>(message: String, data: T? = null) : Resource<T>(data, message)
    
    fun isLoading() = this is Loading
    fun isSuccess() = this is Success
    fun isError() = this is Error
} 