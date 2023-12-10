package com.example.cs2340b_team33dungeoncrawler.model.observers;

import android.widget.ImageView;

import com.example.cs2340b_team33dungeoncrawler.model.Player;
import com.example.cs2340b_team33dungeoncrawler.model.enemies.EnemyFactory;
import com.example.cs2340b_team33dungeoncrawler.model.moveModels.MoveLeft;
import com.example.cs2340b_team33dungeoncrawler.model.moveModels.MovementStrategy;

public class MoveLeftObserver implements MovementObserver {

    private final MovementStrategy moveLeft = new MoveLeft();
    @Override
    public void handleMovement(ImageView sprite) {
        //cannot go out of bounds on left side
        //800 is sprites starting position
        if (sprite.getX() - 65 < 800) {
            return;
        } else {
            Player.getInstance().setMovementStrategy(moveLeft);
            Player.getInstance().move(sprite);
        }
    }

    public void checkCollisions(ImageView sprite) {
        //check if moving down causes a collision between the enemy ArrayList
        //and the sprite

        for (int i = 0; i < EnemyFactory.getEnemies().size(); i++) {
            if (sprite.getX() > EnemyFactory.getEnemies().get(i).getX()
                    && sprite.getX() - 65 <= EnemyFactory.getEnemies().get(i).getX()) {
                return;
            } else {
                Player.getInstance().setMovementStrategy(moveLeft);
                Player.getInstance().move(sprite);
            }
        }
    }


}
