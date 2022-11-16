package com.example.platformer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.platformer.Model.Leaderboard;
import com.example.platformer.Model.LevelPlayed;

import java.util.ArrayList;

public class LeaderboardRVAdapter extends RecyclerView.Adapter<LeaderboardRVAdapter.ViewHolder>{
    // variable for our array list and context
    private ArrayList<Leaderboard> LeaderboardModalArrayList;
    private Context context;

    // constructor
    public LeaderboardRVAdapter(ArrayList<Leaderboard> LeaderboardModalArrayList, Context context) {
        this.LeaderboardModalArrayList = LeaderboardModalArrayList;
        this.context = context;
    }


    @NonNull
    @Override
    public LeaderboardRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // on below line we are inflating our layout
        // file for our recycler view items.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.leaderboard_rv_item, parent, false);
        return new LeaderboardRVAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LeaderboardRVAdapter.ViewHolder holder, int position) {
        // on below line we are setting data
        // to our views of recycler view item.
        Leaderboard modal = LeaderboardModalArrayList.get(position);

        holder.Name.setText(modal.getTop_name());
        holder.BestScore.setText(modal.getBestscore());

    }

    @Override
    public int getItemCount() {
        // returning the size of our array list
        return LeaderboardModalArrayList == null ? 0 : LeaderboardModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // creating variables for our text views.
        private TextView Name, BestScore;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views

            Name = itemView.findViewById(R.id.PlayerName);
            BestScore = itemView.findViewById(R.id.BestScore);


        }
    }
}
