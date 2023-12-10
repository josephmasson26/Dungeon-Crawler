package com.example.cs2340b_team33dungeoncrawler.model.map;

public class Map {
    public static final int TILE_WIDTH_PIXELS = 64;
    public static final int TILE_HEIGHT_PIXELS = 64;
    public static final int NUMBER_OF_ROW_TILES = 60;
    public static final int NUMBER_OF_COL_TILES = 60;

    private int[][] layout;

    public Map() {
        initializeLayout();
    }

    public int[][] getLayout() {
        return layout;
    }

    private void initializeLayout() {
        int[][] layout = new int[64][64]; }
}