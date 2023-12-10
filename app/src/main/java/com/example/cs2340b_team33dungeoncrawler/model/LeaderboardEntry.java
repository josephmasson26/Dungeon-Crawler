package com.example.cs2340b_team33dungeoncrawler.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LeaderboardEntry {

    private final String refId;
    private String player;
    private int score;
    private String date;
    private String time;

    public LeaderboardEntry() {
        this.refId = getDate() + getTime();
        this.player = "xxx";
        this.score = 0;
        this.date = null;
        this.time = null;
    }

    public LeaderboardEntry(String player, int score) {
        this.refId = getDate() + getTime();
        this.player = player;
        this.score = score;
        this.date = new SimpleDateFormat("MM/dd/yyyy").format(new Date());
        this.time = new SimpleDateFormat("HH:mm").format(new Date());
    }

    public void addToLeaderboard() {
        Leaderboard.getInstance().addEntry(this);
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public String getPlayer() {
        return this.player;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return this.score;
    }



    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return this.date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTime() {
        return this.time;
    }

    @Override
    public String toString() {
        return this.player + " | Score: " + this.score
                + " | Date: " + this.date + " | Time: " + this.time;
    }
}

