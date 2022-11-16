package com.example.platformer.Model;

public class LevelPlayed {
    private String levelplayed_name;
    private String levelplayed_difficulty;
    private String timesplayed;



    public String getLevelplayed_name() {
        return levelplayed_name;
    }
    public void setLevelplayed_name(String levelplayed_name) {
        this.levelplayed_name = levelplayed_name;
    }
    public String getLevelplayed_difficulty() {
        return levelplayed_difficulty;
    }
    public void setLevelplayed_difficulty(String levelplayed_difficulty) {
        this.levelplayed_difficulty = levelplayed_difficulty;
    }
    public String getTimesplayed() {
        return timesplayed;
    }
    public void setTimesplayed(String timesplayed) {
        this.timesplayed = timesplayed;
    }


    // constructor
    public LevelPlayed(String LevelPlayed, String LevelPlayedDifficulty, String TimesPlayed) {
        this.levelplayed_name = LevelPlayed;
        this.levelplayed_difficulty = LevelPlayedDifficulty;
        this.timesplayed = TimesPlayed;
    }
}
