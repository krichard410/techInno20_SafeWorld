package com.safeworld.news.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Client {

    public static final String BASE_URL = "https://newsapi.org/v2/";
    public static Retrofit retrofit;
    public static Client client;

    private Client(){
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized Client getInstance(){
        if (client == null) {
            client = new Client();
        }
        return client;
    }

    public ApiInterface getApi(){
        return retrofit.create(ApiInterface.class);
    }

}
