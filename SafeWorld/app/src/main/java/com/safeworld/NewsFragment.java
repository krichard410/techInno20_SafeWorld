package com.safeworld;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.safeworld.news.adapter.Adapter;
import com.safeworld.news.api.Client;
import com.safeworld.news.parameter.Article;
import com.safeworld.news.parameter.News;

import java.util.ArrayList;
import java.util.List;
/**
 * The NewsFragment for displaying the news and send the request to news api
 * @author nieruize
 * @version 1.0
 */
public class NewsFragment extends Fragment {

    // attribute
    public static final String API_KEY = "97061584466e4c1a9ca46b71d0b3247d";
    private RecyclerView recyclerView;
    private List<Article> articles = new ArrayList<>();
    private Adapter adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_news, container, false);

        final String country = Adapter.getCountry();

        recyclerView = root.findViewById(R.id.news_rev);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setNestedScrollingEnabled(false);
        loadJson(country, API_KEY);
        return root;
    }

    // send the request to news api
    public void loadJson(String country, String API_KEY) {
        Call<News> call = Client.getInstance().getApi().getNews(country, API_KEY);
        call.enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                if (response.isSuccessful() && response.body().getArticles() != null){
                    if(!articles.isEmpty()){
                        articles.clear();
                    }
                    articles = response.body().getArticles();
                    adapter = new Adapter(articles, getContext());
                    recyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }else {
                    Toast.makeText(getContext(), "No Result!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                Toast.makeText(getContext(), "Check Your Connection!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}