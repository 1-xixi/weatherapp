package com.example.weather
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface ApiService {
        @GET("free/day")
        suspend fun getWeather(
            @Query("appid")
            appid: String,
            @Query("city")
            city: String,
            @Query("appsecret")
            appsecret: String,
            @Query("unescape")
            unescape: Int = 1
        ): Response<Weather>
}

