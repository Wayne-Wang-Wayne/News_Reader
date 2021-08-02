package com.example.newsreader.service;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class ApiService {

    private static final String readerBaseUrl = "https://hacker-news.firebaseio.com";

    private static ReaderApiService readerApiService;

    public static ReaderApiService getReaderApiService() {

        if (readerApiService == null) {
            OkHttpClient client = new OkHttpClient().newBuilder().build();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(readerBaseUrl)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .client(client).build();

            readerApiService = retrofit.create(ReaderApiService.class);

        }

        return readerApiService;
    }


}
