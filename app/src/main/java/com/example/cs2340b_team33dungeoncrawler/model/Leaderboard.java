package com.example.cs2340b_team33dungeoncrawler.model;
import static java.util.Collections.reverseOrder;

import java.util.ArrayList;
import java.util.Comparator;

public class Leaderboard {

    //Singleton class global variables
    private ArrayList<LeaderboardEntry> entries;
    private LeaderboardEntry mostRecentEntry;

    //Instance named 'instance' is null
    private static Leaderboard instance = null;

    //Constructor for leaderboard object with default assignments
    private Leaderboard() {
        this.entries = new ArrayList<>();
        this.mostRecentEntry = null;
    }

    //Returns the instance of the leaderboard object.
    //If no instance exists, it creates one.
    public static Leaderboard getInstance() {
        if (instance == null) {
            instance = new Leaderboard();
        }
        return instance;
    }

    //Getter and setter methods
    public LeaderboardEntry getMostRecentEntry() {
        return mostRecentEntry;
    }
    public void addEntry(LeaderboardEntry entry) {
        entries.add(entry);
    }
    public void clearEntries() {
        entries.clear();
    }

    //Leaderboard class methods
    public ArrayList<LeaderboardEntry> displayEntries() {
        removeDuplicates();
        this.mostRecentEntry = entries.get(entries.size() - 1);
        this.sortEntriesByScore();
        if (entries.size() < 5) {
            for (int i = entries.size(); i < 5; i++) {
                entries.add(new LeaderboardEntry());
            }
        } else if (entries.size() > 5) {
            int x = 5;
            for (int i = 5; i < entries.size() - 5; i++) {
                entries.remove(x);
            }
        }
        entries.add(mostRecentEntry);
        return entries;
    }

    public void sortEntriesByScore() {
        entries.sort(reverseOrder(compareByScore));
    }

    public void removeDuplicates() {
        ArrayList<LeaderboardEntry> temp = new ArrayList<>();
        for (LeaderboardEntry entry : entries) {
            if (!temp.contains(entry)) {
                temp.add(entry);
            }
        }
        entries = temp;
    }

    private final Comparator<LeaderboardEntry> compareByScore =
            (LeaderboardEntry o1, LeaderboardEntry o2)
                    -> o1.getScore() - o2.getScore();

}
