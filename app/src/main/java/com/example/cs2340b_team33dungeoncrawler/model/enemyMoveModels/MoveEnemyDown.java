package com.example.cs2340b_team33dungeoncrawler.model.enemyMoveModels;

import android.widget.ImageView;

public class MoveEnemyDown implements EnemyMovementStrategy {
    @Override
    public void move(ImageView sprite, double movement) {
        sprite.setY((float) ((sprite.getY() + 65) * movement));
    }
}
