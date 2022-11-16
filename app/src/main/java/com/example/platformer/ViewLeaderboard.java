package com.example.platformer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.platformer.Model.Leaderboard;
import com.example.platformer.Model.LevelPlayed;
import com.example.platformer.SQL.DatabaseHelper;

import java.util.ArrayList;

public class ViewLeaderboard extends AppCompatActivity {
    // creating variables for our array list,
    // dbHelper, adapter and recycler view.
    private ArrayList<Leaderboard> leaderboardModalArrayList;
    private DatabaseHelper databaseHelper;
    private LeaderboardRVAdapter LeaderboardRVAdapter;
    private RecyclerView LeaderboardRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_leaderboard);
        // initializing our all variables.
        leaderboardModalArrayList = new ArrayList<>();
        databaseHelper = new DatabaseHelper(ViewLeaderboard.this);

        // getting our course array
        // list from db handler class.
        leaderboardModalArrayList = databaseHelper.readLeaderboard();

        // on below line passing our array lost to our adapter class.
        LeaderboardRVAdapter = new LeaderboardRVAdapter(leaderboardModalArrayList, ViewLeaderboard.this);
        LeaderboardRV = findViewById(R.id.idRVLeaderboard);

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ViewLeaderboard.this, RecyclerView.VERTICAL, false);
        LeaderboardRV.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        LeaderboardRV.setAdapter(LeaderboardRVAdapter);

    }
}