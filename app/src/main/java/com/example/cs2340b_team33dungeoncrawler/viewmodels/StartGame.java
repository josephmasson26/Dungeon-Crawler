package com.example.cs2340b_team33dungeoncrawler.viewmodels;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.cs2340b_team33dungeoncrawler.R;
import com.example.cs2340b_team33dungeoncrawler.model.Player;


public class StartGame extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.config_screen);

        Player player = Player.getInstance();

        RadioGroup difficultyRadio = (RadioGroup) findViewById(R.id.radioGroup);
        difficultyRadio.clearCheck();
        RadioGroup characterSelection = (RadioGroup) findViewById(R.id.charGroup);
        characterSelection.clearCheck();
        final EditText name = (EditText) findViewById(R.id.playerName);

        Button startButton = (Button) findViewById(R.id.button8);

        Player.getInstance().setStartTime();

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (nameCheck(name, player) && difficultyCheck(difficultyRadio, player)
                        && characterCheck(characterSelection, player)) {
                    Intent game = new Intent(StartGame.this, Room1.class);

                    startActivity(game);
                    finish();
                }
            }
        });
    }

    public boolean nameCheck(EditText name, Player player) {
        String nameValue = name.getText().toString();
        int id = player.nameCheck(nameValue);
        if (id == 1) {
            Toast.makeText(getApplicationContext(), "Player name cannot be null",
                    Toast.LENGTH_LONG).show();
            return false;
        } else if (id == 2) {
            Toast.makeText(getApplicationContext(), "Player name cannot be empty",
                    Toast.LENGTH_LONG).show();
            return false;
        } else if (id == 3) {
            Toast.makeText(getApplicationContext(), "Player name cannot be only whitespaces",
                    Toast.LENGTH_LONG).show();
            return false;
        } else {
            player.setPlayerNameValue(nameValue);
            return true;
        }
    }

    public boolean difficultyCheck(RadioGroup difficultyRadio, Player player) {
        String id = player.difficultyCheck(difficultyRadio, player);
        if (id.equals("unselected")) {
            Toast.makeText(StartGame.this, "Difficulty Must Be Set", Toast.LENGTH_SHORT).show();
            return false;
        } else if (id.equals("selected")) {
            return true;
        }
        return false;
    }

    private boolean characterCheck(RadioGroup characterSelection, Player player) {
        String id = player.characterCheck(characterSelection, player);
        if (id.equals("unselected")) {
            Toast.makeText(StartGame.this, "You Must Select A Character!",
                    Toast.LENGTH_SHORT).show();
            return false;
        } else if (id.equals("selected")) {
            return true;
        }
        return false;
    }
}
