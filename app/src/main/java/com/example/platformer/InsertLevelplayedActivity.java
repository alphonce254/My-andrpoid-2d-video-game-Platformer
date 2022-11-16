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

public class InsertLevelplayedActivity extends AppCompatActivity {
    private RelativeLayout relativeLayout;
    private TextInputEditText textInputEditTextLevelplayedName;
    private TextInputEditText textInputEditTextLevelplayedDifficulty;
    private TextInputEditText textInputEditTextTimesplayed;
    private AppCompatButton appCompatButtonInsert;
    private AppCompatButton appCompatButtonView;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_levelplayed);
        relativeLayout = findViewById(R.id.Relativelayout);
        textInputEditTextLevelplayedName = findViewById(R.id.name);
        textInputEditTextLevelplayedDifficulty = findViewById(R.id.difficulty);
        textInputEditTextTimesplayed = findViewById(R.id.timeplayed);
        appCompatButtonInsert = findViewById(R.id.btnInsert);
        appCompatButtonView = findViewById(R.id.btnView);
        databaseHelper = new DatabaseHelper(this);

        appCompatButtonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String LevelName = textInputEditTextLevelplayedName.getText().toString().trim();
                String LevelDifficulty = textInputEditTextLevelplayedDifficulty.getText().toString().trim();
                String TimesPlayed = textInputEditTextTimesplayed.getText().toString().trim();




                databaseHelper.addLevelPlayed(LevelName, LevelDifficulty, TimesPlayed);
                // after adding the data we are displaying a toast message.
                Toast.makeText(InsertLevelplayedActivity.this, "levelplayed has been added.", Toast.LENGTH_SHORT).show();
                textInputEditTextLevelplayedName.setText("");
                textInputEditTextLevelplayedDifficulty.setText("");
                for (TextInputEditText textInputEditText : Arrays.asList(textInputEditTextTimesplayed)) {
                    textInputEditText.setText("");
                }


            }

        });
        appCompatButtonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ViewLevelplayed.class);
                startActivity(i);

            }
        });


    }
}