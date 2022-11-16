package com.example.platformer.Model;

public class Leaderboard {
    private String top_name;
    private String bestscore;

    public String getTop_name() {return top_name;}

    public void setTop_name(String top_name) {
        this.top_name = top_name;
    }

    public String getBestscore() {
        return bestscore;
    }
    public void setBestscore(String bestscore) {
        this.bestscore = bestscore;
    }

    // constructor
    public Leaderboard(String TopName,String BestScore) {
        this.top_name = TopName;
        this.bestscore = BestScore;

    }
}
