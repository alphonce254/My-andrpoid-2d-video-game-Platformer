package com.example.platformer;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.platformer.Model.Level;
import com.example.platformer.Model.User;
import com.example.platformer.SQL.DatabaseHelper;

import java.util.ArrayList;

public class ViewLevels extends AppCompatActivity {
    // creating variables for our array list,
    // dbHelper, adapter and recycler view.
    private ArrayList<Level> levelModalArrayList;
    private DatabaseHelper databaseHelper;
    private LevelRVAdapter LevelsRVAdapter;
    private RecyclerView LevelsRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_level);

        // initializing our all variables.
        levelModalArrayList = new ArrayList<>();
        databaseHelper = new DatabaseHelper(ViewLevels.this);

        // getting our course array
        // list from db handler class.
        levelModalArrayList = databaseHelper.readLevels();

        // on below line passing our array lost to our adapter class.
        LevelsRVAdapter = new LevelRVAdapter(levelModalArrayList, ViewLevels.this);
        LevelsRV = findViewById(R.id.idRVLevels);

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ViewLevels.this, RecyclerView.VERTICAL, false);
        LevelsRV.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        LevelsRV.setAdapter(LevelsRVAdapter);
    }
}
