package com.hepsihikaye.android.api

import com.hepsihikaye.android.model.HomeResponse
import retrofit2.Response
import retrofit2.http.GET

interface HepsihikayeApi {
    @GET("api/home")
    suspend fun getHomeData(): Response<HomeResponse>
    
    companion object {
        const val BASE_URL = "https://hepsihikaye.net/"
    }
} 