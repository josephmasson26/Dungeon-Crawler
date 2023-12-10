package com.example.cs2340b_team33dungeoncrawler;

import org.junit.Test;
import static org.junit.Assert.*;

import android.view.View;
import android.widget.Button;

import com.example.cs2340b_team33dungeoncrawler.model.Leaderboard;
import com.example.cs2340b_team33dungeoncrawler.model.LeaderboardEntry;
import com.example.cs2340b_team33dungeoncrawler.model.Player;
import com.example.cs2340b_team33dungeoncrawler.model.observers.MoveLeftObserver;
import com.example.cs2340b_team33dungeoncrawler.model.observers.MovementSubject;


public class UnitTest {

    //Joseph's tests
    @Test
    public void testPlayerNameNull() {
        Player player = Player.getInstance();
        assertEquals(1, player.nameCheck(null));
    }

    @Test
    public void testPlayerNameEmpty() {
        Player player = Player.getInstance();
        assertEquals(2, player.nameCheck(""));
    }

    //Austin's tests
    @Test
    public void testPlayerBaseHp() {
        Player player = Player.getInstance();
        assertEquals(100, player.getBaseHp());
    }

    @Test
    public void testPlayerDefaultHp() {
        Player player = Player.getInstance();
        assertEquals(100, player.getBaseHp());
    }

    @Test
    public void testPlayerDefaultDifficulty() {
        Player player = Player.getInstance();
        assertEquals(1.0, player.getGameDifficultyMultiplier(), 0);
        assertEquals("Medium", player.getChosenDifficulty());
    };
    
    //Yuzif's tests
    @Test
    public void testPlayerWhitespace() {
        Player player = Player.getInstance();
        assertEquals(3, player.nameCheck(" "));
    }
    @Test
    public void testPlayerHpBelowZero() {
        Player player = Player.getInstance();
        assertEquals(100, player.getHp(), 0);
    };

    //Shube's tests
    @Test
    public void testMediumHp() {
        Player player = Player.getInstance();
        player.setChosenDifficulty("Medium");
        player.setGameDifficultyMultiplier(player.setMultiplier(player.getChosenDifficulty()));;
        player.setHp(player.getBaseHp() * player.getGameDifficultyMultiplier());
        assertEquals(100, player.getHp(), 0.001);
    };

    @Test
    public void testHardHp() {
        Player player = Player.getInstance();
        player.setChosenDifficulty("Hard");
        player.setGameDifficultyMultiplier(player.setMultiplier(player.getChosenDifficulty()));;
        player.setHp(player.getBaseHp() * player.getGameDifficultyMultiplier());
        assertEquals(75, player.getHp(), 0.001);
    };

    @Test
    public void testEasyHp(){
        Player player = Player.getInstance();
        player.setChosenDifficulty("Easy");
        player.setGameDifficultyMultiplier(player.setMultiplier(player.getChosenDifficulty()));;
        player.setHp(player.getBaseHp() * player.getGameDifficultyMultiplier());
        assertEquals(150, player.getHp(), 0.001);
    };


    //Aadi's tests
    @Test
    public void testLeaderboardSortOne() {
        LeaderboardEntry one = new LeaderboardEntry("A", 1);
        LeaderboardEntry two = new LeaderboardEntry("B", 2);
        LeaderboardEntry three = new LeaderboardEntry("C", 3);

        int[] expected = {3, 2, 1};
        Leaderboard.getInstance().addEntry(one);
        Leaderboard.getInstance().addEntry(two);
        Leaderboard.getInstance().addEntry(three);
        Leaderboard.getInstance().sortEntriesByScore();
        Leaderboard.getInstance().displayEntries();
        for (int i = 0; i < 2; i++) {
            assertEquals(expected[i], Leaderboard.getInstance().displayEntries().get(i).getScore());
        }
    }

    @Test
    public void testLeaderboardSortTwo() {
        LeaderboardEntry one = new LeaderboardEntry("A", 1);
        LeaderboardEntry oneB = new LeaderboardEntry("A", 1);
        LeaderboardEntry two = new LeaderboardEntry("B", 2);
        LeaderboardEntry three = new LeaderboardEntry("C", 3);
        int[] expected = {3, 2, 1};
        Leaderboard.getInstance().addEntry(one);
        Leaderboard.getInstance().addEntry(oneB);
        Leaderboard.getInstance().addEntry(two);
        Leaderboard.getInstance().addEntry(three);
        Leaderboard.getInstance().sortEntriesByScore();
        Leaderboard.getInstance().displayEntries();
        for (int i = 0; i < 2; i++) {
            assertEquals(expected[i], Leaderboard.getInstance().displayEntries().get(i).getScore());
        }
    }

    @Test
    public void testLeaderboardDuplicate() {
        Leaderboard.getInstance().clearEntries();
        LeaderboardEntry one = new LeaderboardEntry("A", 1);
        LeaderboardEntry oneB = new LeaderboardEntry("A", 1);
        LeaderboardEntry two = new LeaderboardEntry("B", 2);
        LeaderboardEntry three = new LeaderboardEntry("C", 3);
        int[] expected = {3, 2, 1};
        Leaderboard.getInstance().addEntry(one);
        Leaderboard.getInstance().addEntry(oneB);
        Leaderboard.getInstance().addEntry(two);
        Leaderboard.getInstance().addEntry(three);
        Leaderboard.getInstance().sortEntriesByScore();
        Leaderboard.getInstance().displayEntries();
        assertEquals(6, Leaderboard.getInstance().displayEntries().size());
    }


}


