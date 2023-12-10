package com.example.cs2340b_team33dungeoncrawler.model.enemies;


import android.view.View;

import java.util.ArrayList;

public class EnemyFactory {
    //initialize a private arraylist of enemies
    private static ArrayList<Enemy> enemies = new ArrayList<>();

    public static ArrayList<Enemy> getEnemies() {
        return enemies;
    }
    private static EnemyFactory instance = null;

    public static Enemy createEnemy(String enemyType) {
        Enemy enemy = null;
        if (enemyType.equals("small")) {
            enemy = new SmallEnemy();
        } else if (enemyType.equals("large")) {
            enemy = new LargeEnemy();
        } else if (enemyType.equals("grunt")) {
            enemy = new GruntEnemy();
        } else if (enemyType.equals("boss")) {
            enemy = new BossEnemy();
        } else {
            throw new IllegalArgumentException("Invalid enemy type: " + enemyType);
        }
        enemies.add(enemy);
        return enemy;
    }

    public static synchronized EnemyFactory getInstance() {
        if (instance == null) {
            instance = new EnemyFactory();
        }
        return instance;
    }

    public static void clearArray() {
        enemies.clear();
    }

    public static void addEnemy(Enemy enemy) {
        enemies.add(enemy);
    }

    public static void removeDeadEnemies(ArrayList<Enemy> enemies) {
        for (Enemy r: enemies) {
            if (!r.isAlive()) {
                r.getSprite().setVisibility(View.GONE);
            }
        }
    }

}
