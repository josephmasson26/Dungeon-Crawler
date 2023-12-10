package com.example.cs2340b_team33dungeoncrawler.views;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.cs2340b_team33dungeoncrawler.R;
import com.example.cs2340b_team33dungeoncrawler.model.Leaderboard;
import com.example.cs2340b_team33dungeoncrawler.viewmodels.StartGame;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.start_screen);
    }

    public void startButton(View v) {
        Intent config = new Intent(MainActivity.this, StartGame.class);
        startActivity(config);
        finish();
    }

    public void quitButton(View v) {
        Leaderboard.getInstance().clearEntries();
        this.finishAffinity();
    }
}
