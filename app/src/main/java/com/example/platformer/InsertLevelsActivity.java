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

public class InsertLevelsActivity extends AppCompatActivity {
    private RelativeLayout relativeLayout;
    private TextInputEditText textInputEditTextPlayerName;
    private TextInputEditText textInputEditTextLevelName;
    private TextInputEditText textInputEditTextDifficulty;
    private TextInputEditText textInputEditTextHighScore;
    private AppCompatButton appCompatButtonInsert;
    private AppCompatButton appCompatButtonView;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_levels);
        relativeLayout = findViewById(R.id.Relativelayout);
        textInputEditTextPlayerName = findViewById(R.id.player);
        textInputEditTextLevelName = findViewById(R.id.name);
        textInputEditTextDifficulty = findViewById(R.id.difficulty);
        textInputEditTextHighScore= findViewById(R.id.highscore);
        appCompatButtonInsert = findViewById(R.id.btnInsert);
        appCompatButtonView = findViewById(R.id.btnView);
        databaseHelper = new DatabaseHelper(this);

        appCompatButtonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    String PlayerName = textInputEditTextPlayerName.getText().toString().trim();
                    String LevelName = textInputEditTextLevelName.getText().toString().trim();
                    String LevelDifficulty = textInputEditTextDifficulty.getText().toString().trim();
                    String LevelHighScore = textInputEditTextHighScore.getText().toString().trim();




                    databaseHelper.addLevel(PlayerName,LevelName, LevelDifficulty, LevelHighScore);
                    // after adding the data we are displaying a toast message.
                    Toast.makeText(InsertLevelsActivity.this, "LEVel has been added.", Toast.LENGTH_SHORT).show();
                    textInputEditTextPlayerName.setText("");
                    textInputEditTextLevelName.setText("");
                    textInputEditTextDifficulty.setText("");
                    for (TextInputEditText textInputEditText : Arrays.asList(textInputEditTextHighScore)) {
                        textInputEditText.setText("");
                    }


            }

        });
        appCompatButtonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ViewLevels.class);
                startActivity(i);

            }
        });

    }



}