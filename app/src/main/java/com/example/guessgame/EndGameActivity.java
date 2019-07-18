package com.example.guessgame;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EndGameActivity extends AppCompatActivity {

    private Button play_again, exit;
    private TextView score, highScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);
        String scores = getIntent().getStringExtra("scores");
        play_again = findViewById(R.id.button_playagain);
        exit = findViewById(R.id.button_exit);
        score = findViewById(R.id.your_score_tv);
        highScore = findViewById(R.id.highScore_tv);
        score.setText("Your Score: " + String.valueOf(scores));
        highScore.setText("High Score :0");
    }

    public void onButtonPlay(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void onButtonExit(View view) {
        finish();
        moveTaskToBack(true);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        moveTaskToBack(true);
    }
}
