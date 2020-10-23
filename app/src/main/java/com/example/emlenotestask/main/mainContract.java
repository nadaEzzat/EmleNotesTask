package com.example.emlenotestask.main;

import com.example.emlenotestask.model.FavoritesData;
import com.example.emlenotestask.model.MainModel;
import com.example.emlenotestask.model.RecentData;

import java.util.List;

public interface mainContract {
    interface PresenterInterface {
        void fetchData();
    }

    interface ViewInterface {
        void showFavoritesData(List<FavoritesData> data);
        void showRecentsData(List<RecentData> data);
        void displayError(String msg);
    }
}
