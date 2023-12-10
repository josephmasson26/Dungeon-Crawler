package com.example.cs2340b_team33dungeoncrawler.model.enemyMoveModels;

import android.widget.ImageView;

public class MoveEnemyRight implements EnemyMovementStrategy {
    @Override
    public void move(ImageView sprite, double movement) {
        sprite.setX((float) ((sprite.getX() - 65) * movement));
    }
}
