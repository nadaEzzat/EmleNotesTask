package com.example.emlenotestask.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MainModel {

    @SerializedName("Favorites")
    @Expose
    private List<FavoritesData> Favorites;

    @SerializedName("Recent")
    @Expose
    private List<RecentData> Recent;

    public List<FavoritesData> getFavorites() {
        return Favorites;
    }


    public List<RecentData> getRecent() {
        return Recent;
    }

}



