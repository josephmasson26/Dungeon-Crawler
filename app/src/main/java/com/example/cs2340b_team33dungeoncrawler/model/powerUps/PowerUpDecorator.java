package com.example.cs2340b_team33dungeoncrawler.model.powerUps;

import com.example.cs2340b_team33dungeoncrawler.model.Player;


public class PowerUpDecorator implements PowerUp {
    protected PowerUp wrappee;

    public PowerUpDecorator(PowerUp source) {
        this.wrappee = source;
    }

    @Override
    public void usePowerUp(Player player) {
        this.wrappee.usePowerUp(player);
    }
}

