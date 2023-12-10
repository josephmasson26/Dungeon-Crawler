package com.example.cs2340b_team33dungeoncrawler.model.enemyMoveModels;

import android.widget.ImageView;

public interface EnemyMovementStrategy {
    void move(ImageView sprite, double movement);
}
