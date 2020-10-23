package com.example.emlenotestask.network;

import com.example.emlenotestask.model.Chat;
import com.example.emlenotestask.model.MainModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitInterface {
    @GET("Screen_1.json")
    Call<MainModel> getChats();

    @GET("Screen_2.json")
    Call<Chat> getChatMessages();

}
