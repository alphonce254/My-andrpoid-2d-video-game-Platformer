package com.example.platformer;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.platformer.Model.User;
import com.example.platformer.SQL.DatabaseHelper;

import java.util.ArrayList;

public class ViewUsers extends AppCompatActivity {

    // creating variables for our array list,
    // dbhandler, adapter and recycler view.
    private ArrayList<User> userModalArrayList;
    private DatabaseHelper databaseHelper;
    private UserRVAdapter userRVAdapter;
    private RecyclerView UsersRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_users);

        // initializing our all variables.
        userModalArrayList = new ArrayList<>();
        databaseHelper = new DatabaseHelper(ViewUsers.this);

        // getting our course array
        // list from db handler class.
        userModalArrayList = databaseHelper.readUsers();

        // on below line passing our array lost to our adapter class.
        userRVAdapter = new UserRVAdapter(userModalArrayList, ViewUsers.this);
        UsersRV = findViewById(R.id.idRVUsers);

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ViewUsers.this, RecyclerView.VERTICAL, false);
        UsersRV.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        UsersRV.setAdapter(userRVAdapter);
    }
    // calling on create option menu
    // layout to inflate our menu file.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // below line is to get our inflater
        MenuInflater inflater = getMenuInflater();

        // inside inflater we are inflating our menu file.
        inflater.inflate(R.menu.search_menu, menu);

        // below line is to get our menu item.
        MenuItem searchItem = menu.findItem(R.id.actionSearch);

        // getting search view of our item.
        SearchView searchView = (SearchView) searchItem.getActionView();

        // below line is to call set on query text listener method.
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // inside on query text change method we are
                // calling a method to filter our recycler view.
                filter(newText);
                return false;
            }
        });
        return true;
    }

    private void filter(String text) {
        // creating a new array list to filter our data.
        ArrayList<User> filteredlist = new ArrayList<>();

        // running a for loop to compare elements.
        for (User item : userModalArrayList) {
            // checking if the entered string matched with any item of our recycler view.
            if (item.getName().toLowerCase().contains(text.toLowerCase())) {
                // if the item is matched we are
                // adding it to our filtered list.
                filteredlist.add(item);
            }
        }
        if (filteredlist.isEmpty()) {
            // if no item is added in filtered list we are
            // displaying a toast message as no data found.
            Toast.makeText(this, "No Data Found..", Toast.LENGTH_SHORT).show();
        } else {
            // at last we are passing that filtered
            // list to our adapter class.
            userRVAdapter.filterList(filteredlist);
        }
    }
}
