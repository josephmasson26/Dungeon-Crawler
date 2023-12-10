package com.example.cs2340b_team33dungeoncrawler.model.graphics;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import com.example.cs2340b_team33dungeoncrawler.R;

public class SpriteSheet {
    private static final int SPRITE_WIDTH_PIXELS = 3;
    private static final int SPRITE_HEIGHT_PIXELS = 3;
    private Bitmap bitmap;

    public SpriteSheet(Context context) {
        BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();
        bitmapOptions.inScaled = false;
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.dungeon_tileset, bitmapOptions);
    }

    public Sprite[] getPlayerSpriteArray() {
        Sprite[] spriteArray = new Sprite[3];
        spriteArray[0] = new Sprite(this, new Rect(0*64, 0, 1*64, 64));
        spriteArray[1] = new Sprite(this, new Rect(1*64, 0, 2*64, 64));
        spriteArray[2] = new Sprite(this, new Rect(2*64, 0, 3*64, 64));
        return spriteArray;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public Sprite getWaterSprite() {
        return getSpriteByIndex(1, 0);
    }

    public Sprite getLavaSprite() {
        return getSpriteByIndex(1, 1);
    }

    public Sprite getGroundSprite() {
        return getSpriteByIndex(0, 0);
    }

    public Sprite getGrassSprite() {
        return getSpriteByIndex(1, 3);
    }

    public Sprite getTreeSprite() {
        return getSpriteByIndex(1, 4);
    }


    private Sprite getSpriteByIndex(int idxRow, int idxCol) {
        return new Sprite(this, new Rect(
                idxCol*SPRITE_WIDTH_PIXELS + 3,
                idxRow*SPRITE_HEIGHT_PIXELS + 2,
                (idxCol + 1)*SPRITE_WIDTH_PIXELS + 3,
                (idxRow + 1)*SPRITE_HEIGHT_PIXELS + 2
        ));
    }
}
