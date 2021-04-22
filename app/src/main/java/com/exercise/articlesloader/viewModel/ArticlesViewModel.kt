package com.exercise.articlesloader.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.exercise.articlesloader.api.Api
import com.exercise.articlesloader.api.FetchedData
import com.exercise.articlesloader.model.Article
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ArticlesViewModel : ViewModel() {
    private var articlesList: MutableLiveData<List<Article>?>? = null
    val articles: LiveData<List<Article>?>
        get() {
            if (articlesList == null) {
                articlesList = MutableLiveData()
                loadArticles()
            }
            return articlesList!!
        }

    //This method is using Retrofit to get the JSON data from URL
    private fun loadArticles() {
        val retrofit = Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        val api = retrofit.create(Api::class.java)
        val call = api.articles
        call!!.enqueue(object : Callback<FetchedData?> {
            override fun onResponse(call: Call<FetchedData?>, response: Response<FetchedData?>) {
                articlesList!!.setValue(response.body()!!.data)
            }

            override fun onFailure(call: Call<FetchedData?>, t: Throwable) {
                // TODO: handle failure
                Log.e("NET", "ERROR")
            }

        })
    }
}