package com.example.platformer;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.widget.NestedScrollView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.platformer.Model.User;
import com.example.platformer.SQL.DatabaseHelper;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Arrays;

public class crudActivity extends AppCompatActivity {
    private RelativeLayout relativeLayout;
    private TextInputEditText textInputEditTextUserName;
    private TextInputEditText textInputEditTextEmail;
    private TextInputEditText textInputEditTextContact;
    private TextInputEditText textInputEditTextPassword;
    private AppCompatButton appCompatButtonInsert;
    private AppCompatButton appCompatButtonView;
    private AppCompatButton appCompatButtonReport;
    private AppCompatButton appCompatButtonLevelPlayedReport;
    private AppCompatButton appCompatButtonLeaderBoardReport;
    private DatabaseHelper databaseHelper;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud);
        relativeLayout = findViewById(R.id.Relativelayout);
        textInputEditTextUserName = findViewById(R.id.name);
        textInputEditTextEmail = findViewById(R.id.email);
        textInputEditTextContact= findViewById(R.id.contact);
        textInputEditTextPassword= findViewById(R.id.password);
        appCompatButtonInsert = findViewById(R.id.btnInsert);
        appCompatButtonView = findViewById(R.id.btnView);
        appCompatButtonReport = findViewById(R.id.btnReport);
        appCompatButtonLevelPlayedReport = findViewById(R.id.btnSecondReport);
        appCompatButtonLeaderBoardReport = findViewById(R.id.btnThirdReport);
        databaseHelper = new DatabaseHelper(this);

        appCompatButtonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!databaseHelper.checkUser(textInputEditTextEmail.getText().toString().trim())) {

                    String UserName = textInputEditTextUserName.getText().toString().trim();
                    String UserEmail = textInputEditTextEmail.getText().toString().trim();
                    String UserContact = textInputEditTextContact.getText().toString().trim();
                    String UserPassword = textInputEditTextPassword.getText().toString().trim();
                    // validating if the text fields are empty or not.
                    if (UserName.isEmpty() && UserEmail.isEmpty() && UserPassword.isEmpty()) {
                        Toast.makeText(crudActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                        return;
                    }


                    databaseHelper.addUser(UserName, UserEmail, UserPassword, UserContact);
                    // after adding the data we are displaying a toast message.
                    Toast.makeText(crudActivity.this, "User has been added.", Toast.LENGTH_SHORT).show();
                    textInputEditTextUserName.setText("");
                    textInputEditTextEmail.setText("");
                    for (TextInputEditText textInputEditText : Arrays.asList(textInputEditTextContact, textInputEditTextPassword)) {
                        textInputEditText.setText("");
                    }

                }
            }

        });
        appCompatButtonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ViewUsers.class);
                startActivity(i);

            }        });

        appCompatButtonReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ViewLevels.class);
                startActivity(i);

            }        });

        appCompatButtonLevelPlayedReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ViewLevelplayed.class);
                startActivity(i);

            }        });

        appCompatButtonLeaderBoardReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ViewLeaderboard.class);
                startActivity(i);

            }        });

    }
}