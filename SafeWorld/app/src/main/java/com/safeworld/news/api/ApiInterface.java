package com.safeworld.news.api;

import com.safeworld.news.parameter.News;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
/**
 * The Interface use for sending the query to news api
 * @author nieruize
 * @version 1.0
 */
public interface ApiInterface {
    @GET("top-headlines")
    Call<News> getNews(
            @Query("country") String country,
            @Query("apikey") String apikey
    );
}
