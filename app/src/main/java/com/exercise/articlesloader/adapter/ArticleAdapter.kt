package com.exercise.articlesloader.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.exercise.articlesloader.R
import com.exercise.articlesloader.adapter.ArticleAdapter.ArticleViewHolder
import com.exercise.articlesloader.model.Article
import com.exercise.articlesloader.model.MetaData.Companion.formatDate

class ArticleAdapter(var context: Context, var articleList: List<Article>) : RecyclerView.Adapter<ArticleViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.article_view_layout, parent, false)
        return ArticleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = articleList[position]
        Glide.with(context)
                .load(article.imageUrl)
                .into(holder.imageView)
        Glide.with(context)
                .load(article.author.authorAvatar.imageUrl)
                .into(holder.authorAvatar)
        holder.title.text = article.title
        holder.saveButton.isSelected = article.isSaved
        holder.likeButton.isSelected = article.isLiked
        holder.category.text = article.category
        holder.likeCount.text = if (article.likesCount != 0) "" + article.likesCount else ""
        holder.authorName.text = article.author.authorName
        holder.lastUpdate.text = formatDate(article.metaData.updateTime)
    }

    override fun getItemCount(): Int {
        return articleList.size
    }

    inner class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageView: ImageView
        var authorAvatar: ImageView
        var saveButton: ImageView
        var likeButton: ImageView
        var title: TextView
        var category: TextView
        var likeCount: TextView
        var authorName: TextView
        var lastUpdate: TextView

        init {
            imageView = itemView.findViewById(R.id.imageView)
            authorAvatar = itemView.findViewById(R.id.author_avatar)
            saveButton = itemView.findViewById(R.id.save_button)
            likeButton = itemView.findViewById(R.id.like_button)
            title = itemView.findViewById(R.id.title)
            category = itemView.findViewById(R.id.category)
            likeCount = itemView.findViewById(R.id.like_count)
            authorName = itemView.findViewById(R.id.author_name)
            lastUpdate = itemView.findViewById(R.id.update_date)
        }
    }

}