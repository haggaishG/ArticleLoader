package com.exercise.articlesloader.viewModel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.exercise.articlesloader.api.Api;
import com.exercise.articlesloader.api.FetchedData;
import com.exercise.articlesloader.model.Article;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ArticlesViewModel extends ViewModel {

    private MutableLiveData<List<Article>> articlesList;

    public LiveData<List<Article>> getArticles() {
        if (articlesList == null) {
            articlesList = new MutableLiveData<List<Article>>();
            loadArticles();
        }

        return articlesList;
    }


    //This method is using Retrofit to get the JSON data from URL 
    private void loadArticles() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);
        Call<FetchedData> call = api.getArticles();


        call.enqueue(new Callback<FetchedData>() {
            @Override
            public void onResponse(Call<FetchedData> call, Response<FetchedData> response) {
                articlesList.setValue(response.body().getData());
            }

            @Override
            public void onFailure(Call<FetchedData> call, Throwable t) {
                // TODO: handle failure
                Log.e("NET", "ERROR");
            }
        });
    }
}