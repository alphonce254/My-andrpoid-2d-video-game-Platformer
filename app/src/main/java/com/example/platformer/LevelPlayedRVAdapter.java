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
import com.example.platformer.Model.LevelPlayed;
import com.example.platformer.Model.User;

import java.util.ArrayList;

public class LevelPlayedRVAdapter extends RecyclerView.Adapter<LevelPlayedRVAdapter.ViewHolder>{
    // variable for our array list and context
    private ArrayList<LevelPlayed> LevelplayedModalArrayList;
    private Context context;

    // constructor
    public LevelPlayedRVAdapter(ArrayList<LevelPlayed> LevelplayedModalArrayList, Context context) {
        this.LevelplayedModalArrayList = LevelplayedModalArrayList;
        this.context = context;
    }


    @NonNull
    @Override
    public LevelPlayedRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // on below line we are inflating our layout
        // file for our recycler view items.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.levelplayed_rv_item, parent, false);
        return new LevelPlayedRVAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LevelPlayedRVAdapter.ViewHolder holder, int position) {
        // on below line we are setting data
        // to our views of recycler view item.
        LevelPlayed modal = LevelplayedModalArrayList.get(position);

        holder.LevelName.setText(modal.getLevelplayed_name());
        holder.LevelDifficulty.setText(modal.getLevelplayed_difficulty());
        holder.TimesPlayed.setText(modal.getTimesplayed());

    }

    @Override
    public int getItemCount() {
        // returning the size of our array list
        return LevelplayedModalArrayList == null ? 0 : LevelplayedModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // creating variables for our text views.
        private TextView  LevelName, LevelDifficulty, TimesPlayed;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views

            LevelName = itemView.findViewById(R.id.LevelName);
            LevelDifficulty = itemView.findViewById(R.id.LevelPlayedDifficulty);
            TimesPlayed = itemView.findViewById(R.id.timesplayed);

        }
    }
}
