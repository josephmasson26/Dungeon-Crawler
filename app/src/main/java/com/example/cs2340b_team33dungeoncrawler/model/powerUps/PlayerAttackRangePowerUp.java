package com.example.cs2340b_team33dungeoncrawler.model.powerUps;

import com.example.cs2340b_team33dungeoncrawler.model.Player;

public class PlayerAttackRangePowerUp implements PowerUp {
    private Player player;
    public PlayerAttackRangePowerUp(Player player) {
        this.player = player; }

    public void usePowerUp(Player player) {
        this.player.setAdditionalAttackRange(75);
    }
}
