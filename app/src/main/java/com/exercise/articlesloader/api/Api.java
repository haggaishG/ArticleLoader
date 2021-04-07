package com.exercise.articlesloader.api;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    String BASE_URL = "https://cdn.theculturetrip.com/home-assignment/";

    @GET("response.json")
    Call<FetchedData> getArticles();
}