package com.example.myapplication.service;

import com.example.myapplication.model.ReaderNews;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ReaderApiServiceJson {
    @GET("/v0/item/{newsId}.json?print=pretty")
    Call<ReaderNews> getSpecificNews(@Path("newsId") String newsId);
}