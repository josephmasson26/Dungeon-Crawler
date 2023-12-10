package com.example.cs2340b_team33dungeoncrawler.model.moveModels;

import android.widget.ImageView;

public class MoveRight implements MovementStrategy {

    @Override
    public void move(ImageView sprite) {
        sprite.setX(sprite.getX() + 65);
    }
}
