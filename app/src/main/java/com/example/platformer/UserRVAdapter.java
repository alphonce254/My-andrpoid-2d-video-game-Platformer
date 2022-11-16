package com.example.platformer;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.platformer.Model.User;

import java.util.ArrayList;

public class UserRVAdapter extends RecyclerView.Adapter<UserRVAdapter.ViewHolder> {

    // variable for our array list and context
    private ArrayList<User> UserModalArrayList;
    private Context context;

    // constructor
    public UserRVAdapter(ArrayList<User> UserModalArrayList, Context context) {
        this.UserModalArrayList = UserModalArrayList;
        this.context = context;
    }

    // method for filtering our recyclerview items.
    public void filterList(ArrayList<User> filterllist) {
        // below line is to add our filtered
        // list in our course array list.
        UserModalArrayList = filterllist;
        // below line is to notify our adapter
        // as change in recycler view data.
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // on below line we are inflating our layout
        // file for our recycler view items.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // on below line we are setting data
        // to our views of recycler view item.
        User modal = UserModalArrayList.get(position);
        holder.UserName.setText(modal.getName());
        holder.UserEmail.setText(modal.getEmail());
        holder.UserPassword.setText(modal.getPassword());
        holder.UserContact.setText(modal.getContact());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // on below line we are calling an intent.
                Intent i = new Intent(context, UpdateUsersActivity.class);

                // below we are passing all our values.
                i.putExtra("name", modal.getName());
                i.putExtra("email", modal.getEmail());
                i.putExtra("password", modal.getPassword());
                i.putExtra("contact", modal.getContact());

                // starting our activity.
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        // returning the size of our array list
        return UserModalArrayList == null ? 0 : UserModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // creating variables for our text views.
        private TextView UserName, UserEmail, UserPassword, UserContact;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views
            UserName = itemView.findViewById(R.id.UserName);
            UserEmail = itemView.findViewById(R.id.UserEmail);
            UserPassword = itemView.findViewById(R.id.UserPassword);
            UserContact = itemView.findViewById(R.id.UserContact);
        }
    }
}
