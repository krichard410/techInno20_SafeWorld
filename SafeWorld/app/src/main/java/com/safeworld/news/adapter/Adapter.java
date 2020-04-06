package com.safeworld.news.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.safeworld.R;
import com.safeworld.news.NewsDetails;
import com.safeworld.news.parameter.Article;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Locale;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
/**
 * The Adapter class using for displaying the news list
 * @author nieruize
 * @version 1.0
 */
public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<Article> articles;
    private Context context;

    // constructor
    public Adapter(List<Article> articles, Context context) {
        this.articles = articles;
        this.context = context;
    }

    @NonNull
    @Override
    // inflater the content to view
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(context).inflate(R.layout.activity_news_items, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    // bind the view into view holder
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        final Article art = articles.get(position);
        String imageUrl = art.getUrlToImage();

        holder.title.setText(art.getTitle());
        holder.desc.setText(art.getDescription());
        holder.source.setText(art.getSource().getName());
        holder.author.setText(art.getAuthor());

        Picasso.get().load(imageUrl).into(holder.imageView);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, NewsDetails.class);
                intent.putExtra("url", art.getUrl());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView title, desc, author, published_at, source;
        ImageView imageView;
        CardView cardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            desc = itemView.findViewById(R.id.desc);
            author = itemView.findViewById(R.id.author);
            source = itemView.findViewById(R.id.source);
            imageView = itemView.findViewById(R.id.img);
            cardView = itemView.findViewById(R.id.card);
        }
    }

    public static String getCountry(){
        Locale locale = Locale.getDefault();
        String country = locale.getCountry();
        return country.toLowerCase();
    }
}
