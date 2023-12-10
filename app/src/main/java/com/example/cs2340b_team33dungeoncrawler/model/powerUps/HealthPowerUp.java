package com.example.cs2340b_team33dungeoncrawler.model.powerUps;

import com.example.cs2340b_team33dungeoncrawler.model.Player;

public class HealthPowerUp extends PowerUpDecorator {

    public HealthPowerUp(PowerUp source) {
        super(source);
    }

    @Override
    public void usePowerUp(Player player) {
        super.usePowerUp(player); }
}
