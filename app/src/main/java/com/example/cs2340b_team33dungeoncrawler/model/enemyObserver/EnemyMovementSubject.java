package com.example.cs2340b_team33dungeoncrawler.model.enemyObserver;

import android.widget.ImageView;


import com.example.cs2340b_team33dungeoncrawler.model.enemies.Enemy;

import java.util.ArrayList;
import java.util.List;

public class EnemyMovementSubject {

    private List<EnemyMovementObserver> observers = new ArrayList<>();

    public void addObserver(EnemyMovementObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(EnemyMovementObserver observer) {
        observers.remove(observer);
    }

    public EnemyMovementSubject getObserver() {
        return this;
    }


    /*
    This is the main observer framework.
    When the button press calls notifyObservers(), this method is called.
         */
    public void notifyObservers(ImageView sprite) {
        for (EnemyMovementObserver observer : observers) {
            //Go to MoveLeftObserver.java to see what happens next
            observer.handleMovement(sprite);
        }
    }

    public static void moveEnemies(ArrayList<Enemy> enemies) {
        for (Enemy r: enemies) {
            double movement = r.getMovement() * 65;
            ImageView sprite = r.getSprite();
            int guess =  (int) ((Math.random() * (4 - 0)) + 1);
            if (guess == 1) {
                if ((sprite.getY()  + movement)  < 800) {
                    sprite.setY((float) ((sprite.getY() + movement)));
                }
            } else if (guess == 2) {
                if ((sprite.getX() - movement) > 800) {
                    sprite.setX((float) ((sprite.getX() - movement)));
                }
            } else if (guess == 3) {
                if ((sprite.getX() + movement) < 2050) {
                    sprite.setX((float) ((sprite.getX() + movement)));
                }
            } else if (guess == 4) {
                if ((sprite.getY()  - movement)  > 30) {
                    sprite.setY((float) ((sprite.getY() - movement)));
                }
            }
        }
    }
}

