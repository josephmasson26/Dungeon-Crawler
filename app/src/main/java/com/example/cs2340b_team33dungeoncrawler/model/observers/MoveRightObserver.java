package com.example.cs2340b_team33dungeoncrawler.model.observers;

import android.widget.ImageView;

import com.example.cs2340b_team33dungeoncrawler.model.Player;
import com.example.cs2340b_team33dungeoncrawler.model.enemies.EnemyFactory;
import com.example.cs2340b_team33dungeoncrawler.model.moveModels.MoveRight;
import com.example.cs2340b_team33dungeoncrawler.model.moveModels.MovementStrategy;

public class MoveRightObserver implements MovementObserver {

    private final MovementStrategy moveRight = new MoveRight();
    @Override
    public void handleMovement(ImageView sprite) {
        if (sprite.getX() + 65 > 2050) {
            return;
        } else {
            Player.getInstance().setMovementStrategy(moveRight);
            Player.getInstance().move(sprite);
        }

    }

    public void checkCollisions(ImageView sprite) {
        for (int i = 0; i < EnemyFactory.getEnemies().size(); i++) {
            if (sprite.getX() < EnemyFactory.getEnemies().get(i).getX()
                    && sprite.getX() + 65 >= EnemyFactory.getEnemies().get(i).getX()) {
                return;
            } else {
                Player.getInstance().setMovementStrategy(moveRight);
                Player.getInstance().move(sprite);
            }
        }
    }
}
