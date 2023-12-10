package com.example.cs2340b_team33dungeoncrawler.model.moveModels;

import android.widget.ImageView;

public class MoveDown implements MovementStrategy {


    @Override
    public void move(ImageView sprite) {
        sprite.setY(sprite.getY() + 65);
    }
}
