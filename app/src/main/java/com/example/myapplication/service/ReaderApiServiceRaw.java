package com.example.myapplication.service;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ReaderApiServiceRaw {
    @GET("/v0/topstories.json?print=pretty")
    Call<String> getMoreInformation();
}