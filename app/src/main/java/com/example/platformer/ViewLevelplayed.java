package com.example.platformer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.platformer.Model.Level;
import com.example.platformer.Model.LevelPlayed;
import com.example.platformer.SQL.DatabaseHelper;

import java.util.ArrayList;

public class ViewLevelplayed extends AppCompatActivity {
    // creating variables for our array list,
    // dbHelper, adapter and recycler view.
    private ArrayList<LevelPlayed> levelplayedModalArrayList;
    private DatabaseHelper databaseHelper;
    private LevelPlayedRVAdapter LevelsPlayedRVAdapter;
    private RecyclerView LevelplayedRV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_levelplayed);

        // initializing our all variables.
        levelplayedModalArrayList = new ArrayList<>();
        databaseHelper = new DatabaseHelper(ViewLevelplayed.this);

        // getting our course array
        // list from db handler class.
        levelplayedModalArrayList = databaseHelper.readLevelplayed();

        // on below line passing our array lost to our adapter class.
        LevelsPlayedRVAdapter = new LevelPlayedRVAdapter(levelplayedModalArrayList, ViewLevelplayed.this);
        LevelplayedRV = findViewById(R.id.idRVLevelPlayed);

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ViewLevelplayed.this, RecyclerView.VERTICAL, false);
        LevelplayedRV.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        LevelplayedRV.setAdapter(LevelsPlayedRVAdapter);
    }
}