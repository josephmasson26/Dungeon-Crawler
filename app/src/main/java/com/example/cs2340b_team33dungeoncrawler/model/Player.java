package com.example.cs2340b_team33dungeoncrawler.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;

import com.example.cs2340b_team33dungeoncrawler.model.enemies.Enemy;
import com.example.cs2340b_team33dungeoncrawler.model.enemies.EnemyFactory;
import com.example.cs2340b_team33dungeoncrawler.model.moveModels.MovementStrategy;

import java.io.Serializable;
import java.util.Timer;

public class Player implements Serializable, Parcelable {
    //Private object variables
    private String playerNameValue;
    private Double gameDifficultyMultiplier;
    private String chosenDifficulty;
    private String character;
    private int baseHp = 100;
    private double hp;
    private double additionalAttackRange = 0;
    private Timer gameStart;
    private long startTime;
    private MovementStrategy movementStrategy;
    private int[] size;
    private int bonus;

    private boolean dead;
    private int score;

    //Singleton global instance
    private static Player instance = null;

    //Private player constructor
    private Player() {
        this.playerNameValue = "default";
        this.gameDifficultyMultiplier = 1.0;
        this.chosenDifficulty = "Medium";
        this.character = "Character";
        this.hp = baseHp;
        this.size = new int[]{120, 140};
        this.dead = false;
        this.bonus = 0;
    }

    //Global player access point
    public static synchronized Player getInstance() {
        if (instance == null) {
            instance = new Player();
        }
        return instance;
    }

    //Player constructor for parcelable
    protected Player(Parcel in) {
        playerNameValue = in.readString();
        if (in.readByte() == 0) {
            gameDifficultyMultiplier = null;
        } else {
            gameDifficultyMultiplier = in.readDouble();
        }
        chosenDifficulty = in.readString();
        character = in.readString();
        baseHp = in.readInt();
        hp = in.readDouble();
    }

    public int[] getSize() {
        return size;
    }

    public static final Creator<Player> CREATOR = new Creator<Player>() {
        @Override
        public Player createFromParcel(Parcel in) {
            return new Player(in);
        }

        @Override
        public Player[] newArray(int size) {
            return new Player[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    //Setter methods
    public void setPlayerNameValue(String playerNameValue) {
        this.playerNameValue = playerNameValue;
    }

    public void setGameDifficultyMultiplier(Double gameDifficultyMultiplier) {
        this.gameDifficultyMultiplier = gameDifficultyMultiplier;
    }

    public void setChosenDifficulty(String chosenDifficulty) {
        this.chosenDifficulty = chosenDifficulty;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    public void setAdditionalAttackRange(double additionalRange) {
        this.additionalAttackRange = additionalRange;
    }

    public double getAdditionalAttackRange() {
        return this.additionalAttackRange;
    }

    public int getScore() {


        this.gameStart = new Timer();
        long y = this.startTime;

        long x = System.currentTimeMillis() - y;


        x *= this.getGameDifficultyMultiplier();
        x /= 1000;
        this.score = (int) x;
        x += this.getBonusScore();
        return (int) x;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setStartTime() {
        this.startTime = System.currentTimeMillis();
    }
    //Getter methods
    public String getPlayerNameValue() {
        return playerNameValue;
    }

    public Double getGameDifficultyMultiplier() {
        return gameDifficultyMultiplier;
    }

    public String getChosenDifficulty() {
        return chosenDifficulty;
    }

    public int getBaseHp() {
        return baseHp;
    }

    public String getCharacter() {
        return character;
    }

    public double getHp() {
        return hp;
    }

    //Clear method
    public void clearPlayer() {
        instance = null;
    }

    //Logic methods for player class (check methods)
    public int nameCheck(String name) {
        if (name == null) {
            return 1;
        } else if (name.matches("")) {
            return 2;
        } else if (name.trim().isEmpty()) {
            return 3;
        } else {
            return 0;
        }
    }

    public String difficultyCheck(RadioGroup difficultyRadio, Player player) {
        int selectedId = difficultyRadio.getCheckedRadioButtonId();
        if (selectedId == -1) {
            return "unselected";
        } else {
            RadioButton selected = difficultyRadio.findViewById(selectedId);
            player.setGameDifficultyMultiplier(setMultiplier(selected.getText().toString()));
            player.setChosenDifficulty(selected.getText().toString());
            return "selected";
        }
    }

    public String characterCheck(RadioGroup characterSelection, Player player) {
        int selectedId = characterSelection.getCheckedRadioButtonId();
        if (selectedId == -1) {
            return "unselected";
        } else {
            RadioButton selected = characterSelection.findViewById(selectedId);
            player.setCharacter(selected.getText().toString());
            return "selected";
        }
    }

    public double setMultiplier(String text) {
        double x = 0;
        if (text.equals("Easy")) {
            x = 1.5;
            return x;
        } else if (text.equals("Medium")) {
            x = 1;
            return x;
        } else if (text.equals("Hard")) {
            x = 0.75;
            return x;
        }
        return x;
    }

    public void setMovementStrategy(MovementStrategy movementStrategy) {
        this.movementStrategy = movementStrategy;
    }
    public MovementStrategy getMovementStrategy() {
        return this.movementStrategy;
    }

    public void attack(ImageView sprite) {
        for (Enemy r:EnemyFactory.getEnemies()) {
            if (r.touchingPlayer(sprite, this.getAdditionalAttackRange())) {

                double y = r.getDamage() * 10;
                Player.getInstance().setBonusScore((int) y);
                r.die();

            }
        }
    }

    public void setBonusScore(int x) {
        this.bonus += x;
    }

    public int getBonusScore() {
        return this.bonus;
    }


    public void move(ImageView sprite) {
        // movementStrategy.move(sprite);
        boolean noCollision = true;
        for (Enemy r:EnemyFactory.getEnemies()) {
            if (r.touchingPlayer(sprite, 0)) {
                noCollision = false;
                this.hp -= (getGameDifficultyMultiplier() * r.getDamage());
            }

            if (this.hp <= 0) {
                //end game scenario
                this.dead = true;
            }
        }

        movementStrategy.move(sprite);

        //update player health
    }

    public boolean isDead() {
        return dead;
    }

    //Parcelable override methods
    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(playerNameValue);
        if (gameDifficultyMultiplier == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(gameDifficultyMultiplier);
        }
        parcel.writeString(chosenDifficulty);
        parcel.writeString(character);
        parcel.writeInt(baseHp);
        parcel.writeDouble(hp);
    }
}

