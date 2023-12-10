package com.example.cs2340b_team33dungeoncrawler.model.map;

import android.graphics.Canvas;
import android.graphics.Rect;

import com.example.cs2340b_team33dungeoncrawler.model.graphics.Sprite;
import com.example.cs2340b_team33dungeoncrawler.model.graphics.SpriteSheet;

public class LavaTile extends Tile {
    private final Sprite sprite;
    public LavaTile(SpriteSheet spriteSheet, Rect mapLocationRect) {
        super(mapLocationRect);
        sprite = spriteSheet.getGroundSprite();
    }

    @Override
    public void draw(Canvas canvas) {
        sprite.draw(canvas, mapLocationRect.left, mapLocationRect.top);
    }
}
