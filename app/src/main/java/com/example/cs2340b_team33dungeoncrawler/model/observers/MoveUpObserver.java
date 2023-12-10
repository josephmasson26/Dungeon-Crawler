package com.example.cs2340b_team33dungeoncrawler.model.observers;

import android.widget.ImageView;

import com.example.cs2340b_team33dungeoncrawler.model.Player;
import com.example.cs2340b_team33dungeoncrawler.model.enemies.EnemyFactory;
import com.example.cs2340b_team33dungeoncrawler.model.moveModels.MoveUp;
import com.example.cs2340b_team33dungeoncrawler.model.moveModels.MovementStrategy;

public class MoveUpObserver implements MovementObserver {
    private final MovementStrategy moveUp = new MoveUp();
    @Override
    public void handleMovement(ImageView sprite) {

        if (sprite.getY()  + 65 < 100) {
            return;
        } else {
            Player.getInstance().setMovementStrategy(moveUp);
            Player.getInstance().move(sprite);
        }
    }

    public boolean checkCollisions(ImageView sprite) {
        //check if moving down causes a collision between the enemy ArrayList
        //and the sprite

        for (int i = 0; i < EnemyFactory.getEnemies().size(); i++) {
            if (sprite.getY() > EnemyFactory.getEnemies().get(i).getY()
                    && sprite.getY() - 65 >= EnemyFactory.getEnemies().get(i).getY()) {
                return true;
            } else {
                Player.getInstance().setMovementStrategy(moveUp);
                Player.getInstance().move(sprite);
            }
        }
        return false;
    }
}
