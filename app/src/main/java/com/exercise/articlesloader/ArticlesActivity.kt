package com.exercise.articlesloader

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.exercise.articlesloader.adapter.ArticleAdapter
import com.exercise.articlesloader.model.Article
import com.exercise.articlesloader.viewModel.ArticlesViewModel

class ArticlesActivity : AppCompatActivity() {
    var recyclerView: RecyclerView? = null
    var adapter: ArticleAdapter? = null
    var articleList: List<Article>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_articles)
        this.recyclerView = findViewById(R.id.articles_recyclerview) as RecyclerView
        recyclerView!!.setHasFixedSize(true)
        recyclerView!!.setLayoutManager(LinearLayoutManager(this))
        val model = ViewModelProviders.of(this).get(ArticlesViewModel::class.java)
        model.articles.observe(this, Observer<List<Article?>?> { articleList ->
            adapter = ArticleAdapter(this@ArticlesActivity, articleList as List<Article>)
            recyclerView!!.setAdapter(adapter)
        })
    }
}