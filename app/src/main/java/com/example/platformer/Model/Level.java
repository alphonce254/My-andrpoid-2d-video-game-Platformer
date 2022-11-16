package com.example.platformer.Model;

public class Level {
    private String player;
    private String level_name;
    private String difficulty;
    private String high_score;

    public String getplayer() {return player;}
    public String getLevel_name() {
        return level_name;
    }
    public void setLevel_name(String level_name) {
        this.level_name = level_name;
    }
    public String getDifficulty() {
        return difficulty;
    }
    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
    public String getHigh_score() {
        return high_score;
    }
    public void setHigh_score(String high_score) {
        this.high_score = high_score;
    }


    // constructor
    public Level(String PlayerName,String LevelName, String LevelDifficulty, String LevelHighscore) {
        this.player = PlayerName;
        this.level_name = LevelName;
        this.difficulty = LevelDifficulty;
        this.high_score = LevelHighscore;
    }
}
