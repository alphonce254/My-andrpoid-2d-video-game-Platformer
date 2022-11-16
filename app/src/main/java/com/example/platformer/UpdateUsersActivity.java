package com.example.platformer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.platformer.SQL.DatabaseHelper;
import com.google.android.material.textfield.TextInputEditText;

public class UpdateUsersActivity extends AppCompatActivity {

    // variables for our edit text, button, strings and dbhandler class.
    private TextInputEditText userNameEdt, userEmailEdt, userContactEdt, userPasswordEdt;
    private AppCompatButton appCompatButtonUpdate, appCompatButtonDelete;
    private DatabaseHelper databaseHelper;
    String userName, userEmail, userPassword, userContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_users);

        // initializing all our variables.
        userNameEdt = findViewById(R.id.idEdtUserName);
        userEmailEdt = findViewById(R.id.idEdtUserEmail);
        userContactEdt = findViewById(R.id.idEdtUserContact);
        userPasswordEdt = findViewById(R.id.idEdtUserPassword);
        appCompatButtonUpdate = findViewById(R.id.idBtnUpdateUsers);
        appCompatButtonDelete = findViewById(R.id.idBtnDeleteUsers);

        // on below line we are initialing our database helper class.
        databaseHelper = new DatabaseHelper(this);

        // on below lines we are getting data which
        // we passed in our adapter class.
        userName = getIntent().getStringExtra("name");
        userEmail = getIntent().getStringExtra("email");
        userContact = getIntent().getStringExtra("contact");
        userPassword = getIntent().getStringExtra("password");

        // setting data to edit text
        // of our update activity.
        userNameEdt.setText(userName);
        userEmailEdt.setText(userEmail);
        userContactEdt.setText(userContact);
        userPasswordEdt.setText(userPassword);

        // adding on click listener to our update user button.
        appCompatButtonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // inside this method we are calling an update course
                // method and passing all our edit text values.
                databaseHelper.updateUser(userName, userNameEdt.getText().toString(), userEmailEdt.getText().toString(), userPasswordEdt.getText().toString(), userContactEdt.getText().toString());


                // displaying a toast message that our course has been updated.
                Toast.makeText(UpdateUsersActivity.this, "User Updated..", Toast.LENGTH_SHORT).show();

                // launching our crud activity.
                Intent i = new Intent(UpdateUsersActivity.this, crudActivity.class);
                startActivity(i);

            }
        });
        // adding on click listener for delete button to delete our user.
        appCompatButtonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calling a method to delete our course.
                databaseHelper.deleteUser(userName);
                Toast.makeText(UpdateUsersActivity.this, "Deleted the USER", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(UpdateUsersActivity.this, crudActivity.class);
                startActivity(i);
            }
        });
    }
}