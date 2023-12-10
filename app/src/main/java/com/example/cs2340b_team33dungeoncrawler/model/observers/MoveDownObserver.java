package com.example.cs2340b_team33dungeoncrawler.model.observers;

import android.widget.ImageView;

import com.example.cs2340b_team33dungeoncrawler.model.Player;
import com.example.cs2340b_team33dungeoncrawler.model.enemies.EnemyFactory;
import com.example.cs2340b_team33dungeoncrawler.model.moveModels.MoveDown;
import com.example.cs2340b_team33dungeoncrawler.model.moveModels.MovementStrategy;

public class MoveDownObserver implements MovementObserver {

    private final MovementStrategy moveDown = new MoveDown();
    @Override
    public void handleMovement(ImageView sprite) {

        // cannot go out of bounds on bottom side

        if (sprite.getY()  + 65 < 800) {
            Player.getInstance().setMovementStrategy(moveDown);
            Player.getInstance().move(sprite);
        } else {
            return;
        }
    }

    public void checkCollisions(ImageView sprite) {
        //check if moving down causes a collision between the enemy ArrayList
        //and the sprite

        for (int i = 0; i < EnemyFactory.getEnemies().size(); i++) {
            if (sprite.getY() < EnemyFactory.getEnemies().get(i).getY()
                && sprite.getY() + 65 >= EnemyFactory.getEnemies().get(i).getY()) {
                //double curr_hp = Player.getInstance().getHp();
                return;
            } else {
                Player.getInstance().setMovementStrategy(moveDown);
                Player.getInstance().move(sprite);
            }
        }
    }
}
