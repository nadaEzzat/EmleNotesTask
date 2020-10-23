package com.example.emlenotestask.main;

import android.util.Log;

import com.example.emlenotestask.model.MainModel;
import com.example.emlenotestask.network.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter implements mainContract.PresenterInterface {
    private mainContract.ViewInterface viewinterface;

    public MainPresenter(mainContract.ViewInterface viewinterface) {
        this.viewinterface = viewinterface;
    }

    @Override
    public void fetchData() {
        RetrofitClient.getINSTANCE().getDataApi().getChats().enqueue(new Callback<MainModel>() {
            @Override
            public void onResponse(Call<MainModel> call, Response<MainModel> response) {
                viewinterface.showFavoritesData(response.body().getFavorites());
                viewinterface.showRecentsData(response.body().getRecent());
            }

            @Override
            public void onFailure(Call<MainModel> call, Throwable t) {
                viewinterface.displayError("Server Error : Please Try Again");
            }
        });
    }
}
