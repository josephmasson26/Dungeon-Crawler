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
import com.example.cs2340b_team33dungeoncrawler.model.powerUps.AttackRangePowerUp;
import com.example.cs2340b_team33dungeoncrawler.model.powerUps.PlayerAttackRangePowerUp;
import com.example.cs2340b_team33dungeoncrawler.model.powerUps.PowerUp;

import java.util.ArrayList;


public class Room1 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.room1);
        final View redFlash = findViewById(R.id.red_flash);
        initialize();
        TextView score = (TextView) findViewById(R.id.textView8);
        score.setText("Score: 0");
        final Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                score.setText("Score: " + Player.getInstance().getScore());
                handler.postDelayed(this, 1000); // Repeat every 1 seconds
            }
        };
        handler.postDelayed(runnable, 1000); // Start the repeating task
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
        Player.getInstance().setHp(Player.getInstance().getBaseHp()
                * Player.getInstance().getGameDifficultyMultiplier());
        TextView hitpoints = (TextView) findViewById(R.id.hp);
        hitpoints.setText("HP: " + Player.getInstance().getHp());
        final Handler hpHandler = new Handler();
        Runnable hpRunnable = new Runnable() {
            @Override
            public void run() {
                hitpoints.setText("HP: " + Player.getInstance().getHp());
                hpHandler.postDelayed(this, 1000); // Repeat every 1 seconds
            }
        };
        hpHandler.postDelayed(hpRunnable, 1000); // Start the repeating task
        ImageView map = (ImageView) findViewById(R.id.mapLayout);
        ImageView sprite = (ImageView) findViewById(R.id.characterSprite);
        sprite.setX(800);
        sprite.setY(450);
        if (Player.getInstance().getCharacter().equals("Plague Doctor")) {
            sprite.setImageResource(R.drawable.sprite3_mace);
        } else if (Player.getInstance().getCharacter().equals("Dinosaur")) {
            sprite.setImageResource(R.drawable.sprite2_axe);
        } else if (Player.getInstance().getCharacter().equals("Knight")) {
            sprite.setImageResource(R.drawable.sprite1_sword);
        }
        ArrayList<Enemy> enemies = new ArrayList<>();
        Enemy enemyOne = EnemyFactory.createEnemy("grunt");
        Enemy enemyTwo = EnemyFactory.createEnemy("small");
        ImageView enemyOneSprite = (ImageView) findViewById(R.id.enemyOne);
        enemyOneSprite.setX(1000);
        enemyOneSprite.setY(300);
        enemyOneSprite.setImageResource(R.drawable.gruntsprite);
        ConstraintLayout.LayoutParams parms =
                new ConstraintLayout.LayoutParams(enemyOne.getSize()[0], enemyOne.getSize()[1]);
        enemyOneSprite.setLayoutParams(parms);
        enemyOne.setSprite(enemyOneSprite);
        enemies.add(enemyOne);
        ImageView enemyTwoSprite = (ImageView) findViewById(R.id.enemyTwo);
        enemyTwoSprite.setX(1250);
        enemyTwoSprite.setY(700);
        enemyTwoSprite.setImageResource(R.drawable.smallsprite);
        ConstraintLayout.LayoutParams parms2 =
                new ConstraintLayout.LayoutParams(enemyTwo.getSize()[0], enemyTwo.getSize()[1]);
        enemyTwoSprite.setLayoutParams(parms2);
        enemyTwo.setSprite(enemyTwoSprite);
        enemies.add(enemyTwo);
        PowerUp playerAttackRangePowerUp = new PlayerAttackRangePowerUp(Player.getInstance());
        AttackRangePowerUp attackRangePowerUp = new AttackRangePowerUp(playerAttackRangePowerUp);
        ImageView attackSprite = (ImageView) findViewById(R.id.powerUpSprite1);
        attackSprite.setX(2115);
        attackSprite.setY(205);
        attackSprite.setImageResource(R.drawable.attack_potion);
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
                if (Math.abs(sprite.getX() - attackSprite.getX()) < 150
                        && Math.abs(sprite.getY() - attackSprite.getY()) < 150) {
                    attackRangePowerUp.usePowerUp(Player.getInstance());
                    Toast.makeText(Room1.this, "Attack Range Increased", Toast.LENGTH_SHORT).show();
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
                if (sprite.getX() >= 840 && sprite.getX() <= 980
                        && sprite.getY() >= 30 && sprite.getY() <= 170) {
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
                if (sprite.getX() >= 840 && sprite.getX() <= 980
                        && sprite.getY() >= 30 && sprite.getY() <= 170) {
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
                if (sprite.getX() >= 840 && sprite.getX() <= 980
                        && sprite.getY() >= 30 && sprite.getY() <= 170) {
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
                if (sprite.getX() >= 840 && sprite.getX() <= 980
                        && sprite.getY() >= 30 && sprite.getY() <= 170) {
                    teleport();
                }
            }
        });
    }
    public void teleport() {
        Intent room2 = new Intent(Room1.this, Room2.class);
        startActivity(room2);
        finish();

    }

    public void end() {
        LeaderboardEntry entry = new LeaderboardEntry(Player.getInstance().getPlayerNameValue(),
                (Player.getInstance().getScore()));
        entry.addToLeaderboard();
        Player.getInstance().clearPlayer();
        Intent end = new Intent(Room1.this, GameOverScreen.class);
        startActivity(end);
        finish();
    }

    public void initialize() {
        TextView playerName = (TextView) findViewById(R.id.playerNameTV);
        playerName.setText("Player Name:" + Player.getInstance().getPlayerNameValue());
        TextView characterName = (TextView) findViewById(R.id.characterplaceholder);
        characterName.setText("Chosen Character: " + Player.getInstance().getCharacter());
        TextView textview7 = (TextView) findViewById(R.id.textview7);
        textview7.setText("Chosen Difficulty: " + Player.getInstance().getChosenDifficulty());

    }
}
