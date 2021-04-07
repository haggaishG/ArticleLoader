package com.exercise.articlesloader;

import android.os.Bundle;

import com.exercise.articlesloader.adapter.ArticleAdapter;
import com.exercise.articlesloader.model.Article;
import com.exercise.articlesloader.viewModel.ArticlesViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import java.util.List;

public class ArticlesActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArticleAdapter adapter;

    List<Article> articleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articles);

        recyclerView = findViewById(R.id.articles_recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArticlesViewModel model = ViewModelProviders.of(this).get(ArticlesViewModel.class);
        model.getArticles().observe(this, new Observer<List<Article>>() {
            @Override
            public void onChanged(@Nullable List<Article> articleList) {
                adapter = new ArticleAdapter(ArticlesActivity.this, articleList);
                recyclerView.setAdapter(adapter);
            }
        });
    }
}