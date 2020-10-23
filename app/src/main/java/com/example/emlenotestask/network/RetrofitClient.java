package com.example.emlenotestask.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    public static final String URL = "https://emlenotes.com/challenges/android/";

    private static RetrofitClient INSTANCE;
    private static RetrofitInterface retrofit;

    public RetrofitInterface getDataApi(){
        return retrofit;
    }
    public static RetrofitClient getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new RetrofitClient();
            retrofit =
                    new Retrofit.Builder()
                            .baseUrl(URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build()
                            .create(RetrofitInterface.class);
        }
        return INSTANCE;
    }
}
