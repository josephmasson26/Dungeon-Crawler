package com.example.cs2340b_team33dungeoncrawler.model.enemies;

import android.widget.ImageView;

import com.example.cs2340b_team33dungeoncrawler.model.moveModels.MovementStrategy;

public class BossEnemy extends Enemy {

    private String type;
    private double damage;
    private double movement;
    private boolean alive;
    private int[] size;
    private MovementStrategy movementStrategy;

    private ImageView sprite;

    private int y;
    private int x;

    public BossEnemy() {
        this.type = "bosssprite";
        this.damage = 20.0;
        this.movement = 1;
        this.size = new int[]{500, 300};
        this.alive = true;
    }


    @Override
    public String getType() {
        return type;
    }

    @Override
    public double getDamage() {
        return damage;
    }

    @Override
    public double getMovement() {
        return movement;
    }

    @Override
    public MovementStrategy getMovementStrategy() {
        return movementStrategy;
    }

    public void setMovementStrategy(MovementStrategy movementStrategy) {
        this.movementStrategy = movementStrategy;
    }

    @Override
    public boolean touchingPlayer(ImageView sprite, double additionalRange) {
        if (Math.abs(this.sprite.getX() - sprite.getX()) < (90 + additionalRange) && this.alive
                && Math.abs(this.sprite.getY() - sprite.getY()) < (90 + additionalRange)) {
            return true;
        }

        return false;
    }
    public boolean isAlive() {
        return this.alive;
    }
    public void die() {
        this.alive = false;
    }

    @Override
    public int[] getSize() {
        return size;
    }

    public void setSprite(ImageView sprite) {
        this.sprite = sprite;
    }
    public ImageView getSprite() {
        return sprite;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
}