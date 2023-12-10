package com.example.cs2340b_team33dungeoncrawler.model.map;

import static com.example.cs2340b_team33dungeoncrawler.model.map.Map.NUMBER_OF_COL_TILES;
import static com.example.cs2340b_team33dungeoncrawler.model.map.Map.NUMBER_OF_ROW_TILES;
import static com.example.cs2340b_team33dungeoncrawler.model.map.Map.TILE_HEIGHT_PIXELS;
import static com.example.cs2340b_team33dungeoncrawler.model.map.Map.TILE_WIDTH_PIXELS;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

import com.example.cs2340b_team33dungeoncrawler.model.graphics.SpriteSheet;
import com.example.cs2340b_team33dungeoncrawler.views.MainActivity;

public abstract class Tile {
    protected final Rect mapLocationRect;

    public Tile(Rect mapLocationRect) {
        this.mapLocationRect = mapLocationRect;
    }
    public enum TileType {
        GROUND_TILE_1,
        WALL_TILE_VERT,
        WALL_TILE_HOR,
        LAVA_TILE,
        DOOR_TILE
    }
    public static Tile getTile(int idxTileType, SpriteSheet spriteSheet, Rect mapLocationRect) {
        switch (TileType.values()[idxTileType]) {
            case GROUND_TILE_1:
                return new GroundTile(spriteSheet, mapLocationRect);
            case WALL_TILE_VERT:
                return new WallTileVert(spriteSheet, mapLocationRect);
            case WALL_TILE_HOR:
                return new WallTileHor(spriteSheet, mapLocationRect);
            case LAVA_TILE:
                return new LavaTile(spriteSheet, mapLocationRect);
            case DOOR_TILE:
                return new DoorTile(spriteSheet, mapLocationRect);
            default:
                return null;
        }
    }
    public abstract void draw(Canvas canvas);
}
