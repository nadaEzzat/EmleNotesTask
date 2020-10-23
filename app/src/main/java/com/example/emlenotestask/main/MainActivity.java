package com.example.emlenotestask.main;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.emlenotestask.R;
import com.example.emlenotestask.adapter.favorits;
import com.example.emlenotestask.adapter.recent;
import com.example.emlenotestask.model.FavoritesData;
import com.example.emlenotestask.model.RecentData;
import com.example.emlenotestask.network.InternetConnection;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements mainContract.ViewInterface {

    @BindView(R.id.backBTN)
    ImageButton backBTN;
    @BindView(R.id.recyclerView_names)
    RecyclerView recyclerViewNames;
    @BindView(R.id.recyclerView_chats)
    RecyclerView recyclerViewChats;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    private mainContract.PresenterInterface presenterInterface;

    private favorits favoritsAdapter;
    private recent recentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        presenterInterface = new MainPresenter(this);
        progressBar.setVisibility(View.VISIBLE);
        if (InternetConnection.checkInternetConnection(this)) {
            presenterInterface.fetchData();
        } else {
            displayError("Please check your internet connection");
            progressBar.setVisibility(View.GONE);
        }

    }

    @Override
    public void showFavoritesData(List<FavoritesData> data) {
        recyclerViewNames.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        favoritsAdapter = new favorits(data, this);
        recyclerViewNames.setAdapter(favoritsAdapter);
    }

    @Override
    public void showRecentsData(List<RecentData> data) {
        recyclerViewChats.setLayoutManager(new LinearLayoutManager(this));
        recentAdapter = new recent(data, this);
        progressBar.setVisibility(View.GONE);
        recyclerViewChats.setAdapter(recentAdapter);
    }

    @Override
    public void displayError(String msg) {
        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
    }
}