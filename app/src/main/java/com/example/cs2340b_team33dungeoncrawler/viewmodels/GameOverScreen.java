package com.example.cs2340b_team33dungeoncrawler.viewmodels;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cs2340b_team33dungeoncrawler.R;
import com.example.cs2340b_team33dungeoncrawler.model.LeaderboardEntry;
import com.example.cs2340b_team33dungeoncrawler.model.Leaderboard;
import com.example.cs2340b_team33dungeoncrawler.views.MainActivity;

import java.util.ArrayList;

public class GameOverScreen extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.gameover_screen);

        ArrayList<LeaderboardEntry> entries = Leaderboard.getInstance().displayEntries();

        TextView score0 = findViewById(R.id.score0);
        TextView score1 = findViewById(R.id.score1);
        TextView textview7 = findViewById(R.id.textView7);
        TextView score3 = findViewById(R.id.score3);
        TextView score4 = findViewById(R.id.score4);
        TextView scoreRecent = findViewById(R.id.scoreRecent);
        int x = entries.size() - 1;
        score0.setText(entries.get(0).toString());
        score1.setText(entries.get(1).toString());
        textview7.setText(entries.get(2).toString());
        score3.setText(entries.get(3).toString());
        score4.setText(entries.get(4).toString());
        scoreRecent.setText("This Play-Through: " + entries.get(x).toString());

        Button restart = findViewById(R.id.restartButton);
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent game = new Intent(GameOverScreen.this, MainActivity.class);
                startActivity(game);
                finish();
            }
        });
    }


}
