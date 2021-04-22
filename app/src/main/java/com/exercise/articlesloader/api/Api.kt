package com.exercise.articlesloader.api

import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @get:GET("response.json")
    val articles: Call<FetchedData?>?

    companion object {
        const val BASE_URL = "https://cdn.theculturetrip.com/home-assignment/"
    }
}