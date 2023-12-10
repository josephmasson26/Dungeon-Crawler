package com.example.cs2340b_team33dungeoncrawler.model.powerUps;

import com.example.cs2340b_team33dungeoncrawler.model.Player;

public class AttackRangePowerUp extends PowerUpDecorator {

    public AttackRangePowerUp(PowerUp source) {
        super(source);
    }

    @Override
    public void usePowerUp(Player player) {
        super.usePowerUp(player);
    }
}
