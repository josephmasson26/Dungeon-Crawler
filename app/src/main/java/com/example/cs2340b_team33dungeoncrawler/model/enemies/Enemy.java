package com.example.cs2340b_team33dungeoncrawler.model.enemies;


import android.widget.ImageView;

import com.example.cs2340b_team33dungeoncrawler.model.moveModels.MovementStrategy;

public abstract class Enemy {

    private MovementStrategy movementStrategy;
    public abstract String getType();
    public abstract double getDamage();
    public abstract double getMovement();
    public abstract MovementStrategy getMovementStrategy();
    public abstract void setMovementStrategy(MovementStrategy movementStrategy);
    public abstract boolean touchingPlayer(ImageView sprite, double additionalRange);
    public abstract void die();
    public abstract boolean isAlive();
    public abstract int[] getSize();
    public abstract void setSprite(ImageView sprite);
    public abstract ImageView getSprite();

    public abstract int getY();

    public abstract int getX();

    public abstract void setX(int x);
}


/*
Private String type
Private int damage
Private int movement
Private int[] size
 */