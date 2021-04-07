package com.exercise.articlesloader.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.exercise.articlesloader.R;
import com.exercise.articlesloader.model.Article;
import com.exercise.articlesloader.model.MetaData;

import java.text.ParseException;
import java.util.List;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder> {

    Context context;
    List<Article> articleList;

    public ArticleAdapter(Context ctx, List<Article> articleList) {
        this.context = ctx;
        this.articleList = articleList;
    }

    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.article_view_layout, parent, false);
        return new ArticleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {
        Article article = articleList.get(position);

        Glide.with(context)
        .load(article.getImageUrl())
        .into(holder.imageView);
        Glide.with(context)
            .load(article.getAuthor().getAuthorAvatar().getImageUrl())
            .into(holder.authorAvatar);

        holder.title.setText(article.getTitle());
        holder.saveButton.setSelected(article.isSaved());
        holder.likeButton.setSelected(article.isLiked());
        holder.category.setText(article.getCategory());
        holder.likeCount.setText(article.getLikesCount()!= 0 ? ""+article.getLikesCount() : "");
        holder.authorName.setText(article.getAuthor().getAuthorName());

        try {
            holder.lastUpdate.setText(MetaData.formatDate(article.getMetaData().getUpdateTime()));
        } catch (ParseException e) {
            e.printStackTrace();
            holder.lastUpdate.setText("---");
        }
    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }

    class ArticleViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        ImageView authorAvatar;
        Button saveButton;
        Button likeButton;
        TextView title;
        TextView category;
        TextView likeCount;
        TextView authorName;
        TextView lastUpdate;

        public ArticleViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            authorAvatar = itemView.findViewById(R.id.author_avatar);
            saveButton = itemView.findViewById(R.id.save_button);
            likeButton = itemView.findViewById(R.id.like_button);
            title = itemView.findViewById(R.id.title);
            category = itemView.findViewById(R.id.category);
            likeCount = itemView.findViewById(R.id.like_count);
            authorName = itemView.findViewById(R.id.author_name);
            lastUpdate = itemView.findViewById(R.id.update_date);
        }
    }
}
 