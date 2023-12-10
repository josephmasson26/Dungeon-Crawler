package com.example.cs2340b_team33dungeoncrawler.model.powerUps;

import com.example.cs2340b_team33dungeoncrawler.model.Player;

public class NukePowerUp extends PowerUpDecorator {
    public NukePowerUp(PowerUp source) {
        super(source); };

    public void usePowerUp(Player player) {
        super.usePowerUp(player); }
}
