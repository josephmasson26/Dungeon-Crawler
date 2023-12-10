package com.example.cs2340b_team33dungeoncrawler.viewmodels;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cs2340b_team33dungeoncrawler.R;
import com.example.cs2340b_team33dungeoncrawler.model.LeaderboardEntry;
import com.example.cs2340b_team33dungeoncrawler.model.Player;
import com.example.cs2340b_team33dungeoncrawler.model.enemies.Enemy;
import com.example.cs2340b_team33dungeoncrawler.model.enemies.EnemyFactory;
import com.example.cs2340b_team33dungeoncrawler.model.enemyObserver.EnemyMovementSubject;
import com.example.cs2340b_team33dungeoncrawler.model.observers.MoveDownObserver;
import com.example.cs2340b_team33dungeoncrawler.model.observers.MoveLeftObserver;
import com.example.cs2340b_team33dungeoncrawler.model.observers.MoveRightObserver;
import com.example.cs2340b_team33dungeoncrawler.model.observers.MoveUpObserver;
import com.example.cs2340b_team33dungeoncrawler.model.observers.MovementSubject;
import com.example.cs2340b_team33dungeoncrawler.model.powerUps.PlayerHealthPowerUp;
import com.example.cs2340b_team33dungeoncrawler.model.powerUps.PowerUp;

import java.util.ArrayList;


public class Room2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.room2);
        final View redFlash = findViewById(R.id.red_flash);
        TextView playerName = (TextView) findViewById(R.id.playerNameTV);
        playerName.setText("Player Name:" + Player.getInstance().getPlayerNameValue());
        TextView characterName = (TextView) findViewById(R.id.characterplaceholder);
        characterName.setText("Chosen Character: " + Player.getInstance().getCharacter());
        TextView textview7 = (TextView) findViewById(R.id.textview7);
        textview7.setText("Chosen Difficulty: " + Player.getInstance().getChosenDifficulty());
        TextView score = (TextView) findViewById(R.id.textView9);
        score.setText("Score: " + Player.getInstance().getScore());
        final Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                score.setText("Score: " + Player.getInstance().getScore());
                handler.postDelayed(this, 1000); // Repeat every 5 seconds
            }
        };
        handler.postDelayed(runnable, 1000);
        ArrayList<Enemy> enemies = new ArrayList<>();
        Enemy enemyOne = EnemyFactory.createEnemy("small");
        Enemy enemyTwo = EnemyFactory.createEnemy("large");
        ImageView enemyOneSprite = (ImageView) findViewById(R.id.enemyOne);
        enemyOneSprite.setX(2000);
        enemyOneSprite.setY(400);
        enemyOneSprite.setImageResource(R.drawable.smallsprite);
        ConstraintLayout.LayoutParams parms =
                new ConstraintLayout.LayoutParams(enemyOne.getSize()[0], enemyOne.getSize()[1]);
        enemyOneSprite.setLayoutParams(parms);
        enemyOne.setSprite(enemyOneSprite);
        enemies.add(enemyOne);
        ImageView enemyTwoSprite = (ImageView) findViewById(R.id.enemyTwo);
        enemyTwoSprite.setX(1000);
        enemyTwoSprite.setY(550);
        enemyTwoSprite.setImageResource(R.drawable.largesprite);
        ConstraintLayout.LayoutParams parms2 =
                new ConstraintLayout.LayoutParams(enemyTwo.getSize()[0], enemyTwo.getSize()[1]);
        enemyTwoSprite.setLayoutParams(parms2);
        enemyTwo.setSprite(enemyTwoSprite);
        enemies.add(enemyTwo);
        Button attackButton = (Button) findViewById(R.id.attackButton);
        Button uButton = (Button) findViewById(R.id.upButton);
        MovementSubject moveUp = new MovementSubject();
        moveUp.addObserver(new MoveUpObserver());
        MovementSubject finalMoveUp = moveUp;
        Button dButton = (Button) findViewById(R.id.downButton);
        MovementSubject moveDown = new MovementSubject();
        moveDown.addObserver(new MoveDownObserver());
        MovementSubject finalMoveDown = moveDown;
        Button lButton = (Button) findViewById(R.id.leftButton);
        MovementSubject moveLeft = new MovementSubject();
        moveLeft.addObserver(new MoveLeftObserver());
        MovementSubject finalMoveLeft = moveLeft;
        Button rButton = (Button) findViewById(R.id.rightButton);
        MovementSubject moveRight = new MovementSubject();
        moveRight.addObserver(new MoveRightObserver());
        MovementSubject finalMoveRight = moveRight;
        TextView hitpoints = (TextView) findViewById(R.id.hp);
        hitpoints.setText("HP: " + Player.getInstance().getHp());
        final Handler hpHandler = new Handler();
        Runnable hpRunnable = new Runnable() {
            @Override
            public void run() {
                hitpoints.setText("HP: " + Player.getInstance().getHp());
                hpHandler.postDelayed(this, 1000); // Repeat every 5 seconds
            }
        };
        hpHandler.postDelayed(hpRunnable, 1000); // Start the repeating task
        ImageView sprite = (ImageView) findViewById(R.id.characterSprite);
        sprite.setX(800);
        sprite.setY(715);
        if (Player.getInstance().getCharacter().equals("Plague Doctor")) {
            sprite.setImageResource(R.drawable.sprite3_mace);
        } else if (Player.getInstance().getCharacter().equals("Dinosaur")) {
            sprite.setImageResource(R.drawable.sprite2_axe);
        } else if (Player.getInstance().getCharacter().equals("Knight")) {
            sprite.setImageResource(R.drawable.sprite1_sword);
        }
        PowerUp healthPowerUp = new PlayerHealthPowerUp(Player.getInstance());
        ImageView healthSprite = (ImageView) findViewById(R.id.powerUpSprite1);
        healthSprite.setX(1450);
        healthSprite.setY(630);
        healthSprite.setImageResource(R.drawable.health_potion);
        attackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Player.getInstance().attack(sprite);
                redFlash.setVisibility(View.VISIBLE);
                redFlash.animate().alpha(0.0f).setDuration(500).withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        redFlash.setVisibility(View.INVISIBLE);
                        redFlash.setAlpha(1.0f);
                    }
                });
                EnemyFactory.removeDeadEnemies(enemies);
                if (Math.abs(sprite.getX() - healthSprite.getX()) < 100
                        && Math.abs(sprite.getY() - healthSprite.getY()) < 100) {
                    healthPowerUp.usePowerUp(Player.getInstance());
                    Toast.makeText(Room2.this, "Health Power Up Used", Toast.LENGTH_SHORT).show();
                }
            }
        });
        uButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EnemyMovementSubject.moveEnemies(enemies);
                finalMoveUp.notifyObservers(sprite);
                if (Player.getInstance().isDead()) {
                    end();
                }
                if (sprite.getX() >= 1945 && sprite.getX() <=  2100
                        && sprite.getY() >= 70 && sprite.getY() <= 200) {
                    teleport();
                }
            }
        });
        dButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EnemyMovementSubject.moveEnemies(enemies);
                finalMoveDown.notifyObservers(sprite);
                if (Player.getInstance().isDead()) {
                    end();
                }
                if (sprite.getX() >= 1945 && sprite.getX() <=  2100
                        && sprite.getY() >= 70 && sprite.getY() <= 200) {
                    teleport();
                }
            }
        });
        lButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EnemyMovementSubject.moveEnemies(enemies);
                finalMoveLeft.notifyObservers(sprite);
                if (Player.getInstance().isDead()) {
                    end();
                }
                if (sprite.getX() >= 1945 && sprite.getX() <=  2100
                        && sprite.getY() >= 70 && sprite.getY() <= 200) {
                    teleport();
                }
            }
        });
        rButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EnemyMovementSubject.moveEnemies(enemies);
                finalMoveRight.notifyObservers(sprite);
                if (Player.getInstance().isDead()) {
                    end();
                }
                if (sprite.getX() >= 1945 && sprite.getX() <=  2100
                        && sprite.getY() >= 70 && sprite.getY() <= 200) {
                    teleport();
                }
            }
        });
    }

    public void teleport() {
        Intent room3 = new Intent(Room2.this, Room3.class);
        startActivity(room3);
        finish();
    }

    public void end() {
        LeaderboardEntry entry = new LeaderboardEntry(Player.getInstance().getPlayerNameValue(),
                (Player.getInstance().getScore()));
        entry.addToLeaderboard();
        Player.getInstance().clearPlayer();
        Intent end = new Intent(Room2.this, GameOverScreen.class);
        startActivity(end);
        finish();
    }
}
