package com.example.myapplication.service;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class ApiService {

    private static final String readerBaseUrl = "https://hacker-news.firebaseio.com";

    private static ReaderApiServiceRaw readerApiServiceRaw;
    private static ReaderApiServiceJson readerApiServiceJson;


    public static ReaderApiServiceRaw getReaderApiServiceRaw() {

        if (readerApiServiceRaw == null) {
            OkHttpClient client = new OkHttpClient().newBuilder().build();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(readerBaseUrl)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .client(client).build();

            readerApiServiceRaw = retrofit.create(ReaderApiServiceRaw.class);

        }

        return readerApiServiceRaw;
    }


    public static ReaderApiServiceJson getReaderApiServiceJson() {

        if (readerApiServiceJson == null) {
            OkHttpClient client = new OkHttpClient().newBuilder().build();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(readerBaseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client).build();

            readerApiServiceJson = retrofit.create(ReaderApiServiceJson.class);

        }

        return readerApiServiceJson;
    }


}