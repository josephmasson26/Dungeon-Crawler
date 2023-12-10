package com.example.cs2340b_team33dungeoncrawler.model.powerUps;

import com.example.cs2340b_team33dungeoncrawler.model.Player;

public class PlayerNukePowerUp implements PowerUp {
    private Player player;

    public PlayerNukePowerUp(Player player) {
        this.player = player;
    }

    public void usePowerUp(Player player) {
        this.player.setAdditionalAttackRange(100000);
    }
}
