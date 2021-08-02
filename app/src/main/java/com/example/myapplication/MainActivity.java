package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.myapplication.model.ReaderNews;
import com.example.myapplication.service.ApiService;
import com.example.myapplication.service.ReaderApiServiceJson;
import com.example.myapplication.service.ReaderApiServiceRaw;
import com.example.myapplication.util.Utility;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ReaderApiServiceRaw readerApiServiceRaw;
    ReaderApiServiceJson readerApiServiceJson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        readerApiServiceRaw = ApiService.getReaderApiServiceRaw();
        readerApiServiceJson = ApiService.getReaderApiServiceJson();

        Call<String> callReader = readerApiServiceRaw.getMoreInformation();

        callReader.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

                String readerResponse = response.body();
                List<String> newsId = Utility.findAllMatches(readerResponse, "\\d+");
                Log.d("", "");

                for (String id : newsId){
                    Call<ReaderNews> newsCall = readerApiServiceJson.getSpecificNews(id);
                    newsCall.enqueue(new Callback<ReaderNews>() {
                        @Override
                        public void onResponse(Call<ReaderNews> call, Response<ReaderNews> response) {
                            ReaderNews readerNews = response.body();
                            if(readerNews.url != null)
                                Log.d("", "");;
                        }

                        @Override
                        public void onFailure(Call<ReaderNews> call, Throwable t) {

                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d("", "");
            }
        });


    }
}