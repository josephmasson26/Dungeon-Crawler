package com.example.cs2340b_team33dungeoncrawler.model.powerUps;


import com.example.cs2340b_team33dungeoncrawler.model.Player;

public class PlayerHealthPowerUp implements PowerUp {
    private Player player;
    public PlayerHealthPowerUp(Player player) {
        this.player = player;
    }

    public void usePowerUp(Player player) {
        this.player.setHp(player.getBaseHp() * player.getGameDifficultyMultiplier());
    }
}
