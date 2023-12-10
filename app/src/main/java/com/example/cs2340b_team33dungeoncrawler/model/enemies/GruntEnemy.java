package com.example.cs2340b_team33dungeoncrawler.model.enemies;

import android.widget.ImageView;

import com.example.cs2340b_team33dungeoncrawler.model.moveModels.MovementStrategy;

public class GruntEnemy extends Enemy {

    private String type;
    private double damage;
    private double movement;
    private boolean alive;
    private int[] size;
    private ImageView sprite;

    private MovementStrategy movementStrategy;

    private int y;
    private int x;

    public GruntEnemy() {
        this.type = "gruntsprite";
        this.damage = 5;
        this.movement = 0.5;
        this.size = new int[]{120, 140};
        this.alive = true;
        //wide, high
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
    public int[] getSize() {
        return size;
    }

    public void setMovementStrategy(MovementStrategy movementStrategy) {
        this.movementStrategy = movementStrategy;
    }

    @Override
    public MovementStrategy getMovementStrategy() {
        return movementStrategy;
    }

    @Override
    public boolean touchingPlayer(ImageView sprite, double additionalRange) {
        if (Math.abs(this.sprite.getX() - sprite.getX()) < (50 + additionalRange) && isAlive()
                && Math.abs(this.sprite.getY() - sprite.getY()) < (50 + additionalRange)) {
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

    @Override
    public void setX(int x) {
        this.x = x;
    }
}
