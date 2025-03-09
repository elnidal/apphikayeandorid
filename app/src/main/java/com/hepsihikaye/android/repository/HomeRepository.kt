package com.hepsihikaye.android.repository

import com.hepsihikaye.android.api.HepsihikayeApi
import com.hepsihikaye.android.model.HomeResponse
import com.hepsihikaye.android.util.Resource
import javax.inject.Inject

class HomeRepository @Inject constructor(
    private val api: HepsihikayeApi
) {
    suspend fun getHomeData(): Resource<HomeResponse> {
        return try {
            val response = api.getHomeData()
            if (response.isSuccessful) {
                response.body()?.let {
                    Resource.Success(it)
                } ?: Resource.Error("Empty response body")
            } else {
                Resource.Error("Error: ${response.code()} - ${response.message()}")
            }
        } catch (e: Exception) {
            Resource.Error(e.message ?: "An error occurred")
        }
    }
} 