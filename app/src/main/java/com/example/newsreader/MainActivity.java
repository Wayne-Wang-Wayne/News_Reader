package com.example.newsreader;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.newsreader.service.ApiService;
import com.example.newsreader.service.ReaderApiService;

import java.util.List;

import model.ReaderResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ReaderApiService readerApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        readerApiService = ApiService.getReaderApiService();

        Call<String> callReader = readerApiService.getMoreInformation();


        callReader.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

                String readerResponse = response.body();





            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d("", "");
            }
        });


    }
}