package com.example.emlenotestask.chat;

import android.util.Log;

import com.example.emlenotestask.model.Chat;
import com.example.emlenotestask.network.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChatPresenter implements ChatContract.presenterInterface {

    ChatContract.viewInterface viewinterface;

    public ChatPresenter(ChatContract.viewInterface viewinterface) {
        this.viewinterface = viewinterface;
    }

    @Override
    public void getChatMessages() {
        RetrofitClient.getINSTANCE().getDataApi().getChatMessages().enqueue(new Callback<Chat>() {
            @Override
            public void onResponse(Call<Chat> call, Response<Chat> response) {
                viewinterface.showMessages(response.body());
            }

            @Override
            public void onFailure(Call<Chat> call, Throwable t) {
               viewinterface.displayError("Server Error : Please Try Again");
            }
        });
    }
}
