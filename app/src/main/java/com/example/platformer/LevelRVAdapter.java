package com.example.platformer;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.platformer.Model.Level;
import com.example.platformer.Model.User;

import java.util.ArrayList;

public class LevelRVAdapter extends RecyclerView.Adapter<LevelRVAdapter.ViewHolder>{
    // variable for our array list and context
    private ArrayList<Level> LevelModalArrayList;
    private Context context;

    // constructor
    public LevelRVAdapter(ArrayList<Level> LevelModalArrayList, Context context) {
        this.LevelModalArrayList = LevelModalArrayList;
        this.context = context;
    }


    @NonNull
    @Override
    public LevelRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // on below line we are inflating our layout
        // file for our recycler view items.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.level_rv_item, parent, false);
        return new LevelRVAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LevelRVAdapter.ViewHolder holder, int position) {
        // on below line we are setting data
        // to our views of recycler view item.
        Level modal = LevelModalArrayList.get(position);
        holder.PlayerName.setText(modal.getplayer());
        holder.LevelName.setText(modal.getLevel_name());
        holder.LevelDifficulty.setText(modal.getDifficulty());
        holder.LevelHighScore.setText(modal.getHigh_score());

    }

    @Override
    public int getItemCount() {
        // returning the size of our array list
        return LevelModalArrayList == null ? 0 : LevelModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // creating variables for our text views.
        private TextView PlayerName, LevelName, LevelDifficulty, LevelHighScore;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views
            PlayerName = itemView.findViewById(R.id.PlayerName);
            LevelName = itemView.findViewById(R.id.LevelName);
            LevelDifficulty = itemView.findViewById(R.id.LevelDifficulty);
            LevelHighScore = itemView.findViewById(R.id.LevelHighScore);

        }
    }
}
