package com.example.newsreader.service;

import model.ReaderResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ReaderApiService {
    @GET("/v0/topstories.json?print=pretty")
    Call<String> getMoreInformation();
}
