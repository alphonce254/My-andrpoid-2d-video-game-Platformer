package com.example.platformer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.platformer.SQL.DatabaseHelper;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Arrays;

public class InsertLeaderboardActivity extends AppCompatActivity {
    private RelativeLayout relativeLayout;
    private TextInputEditText textInputEditTextPlayerName;
    private TextInputEditText textInputEditTextBestScore;
    private AppCompatButton appCompatButtonInsert;
    private AppCompatButton appCompatButtonView;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_leaderboard);
        relativeLayout = findViewById(R.id.Relativelayout);
        textInputEditTextPlayerName = findViewById(R.id.name);
        textInputEditTextBestScore = findViewById(R.id.bestscore);
        appCompatButtonInsert = findViewById(R.id.btnInsert);
        appCompatButtonView = findViewById(R.id.btnView);
        databaseHelper = new DatabaseHelper(this);

        appCompatButtonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String PlayerName = textInputEditTextPlayerName.getText().toString().trim();
                String BestScore = textInputEditTextBestScore.getText().toString().trim();





                databaseHelper.addLeaderboard(PlayerName, BestScore);
                // after adding the data we are displaying a toast message.
                Toast.makeText(InsertLeaderboardActivity.this, "leaderboard has been added.", Toast.LENGTH_SHORT).show();
                textInputEditTextPlayerName.setText("");
                for (TextInputEditText textInputEditText : Arrays.asList(textInputEditTextBestScore)) {
                    textInputEditText.setText("");
                }


            }

        });
        appCompatButtonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ViewLeaderboard.class);
                startActivity(i);

            }
        });



    }
}