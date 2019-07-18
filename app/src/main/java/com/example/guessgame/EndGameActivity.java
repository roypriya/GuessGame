package com.example.guessgame;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;

public class EndGameActivity extends AppCompatActivity {

    private Button play_again, exit;
    private TextView score, highScore;
    private EditText Player_name;
    Context mContext = this;
    SharedPreferences mSharedPreferences = mContext.getSharedPreferences(MainActivity.ab, MODE_PRIVATE);
    RealmResults<Player> mPlayers;
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
        String name = mSharedPreferences.getString("name", null);
        Realm realm = Realm.getDefaultInstance();
        Player playerRealmQuery = realm.where(Player.class).equalTo("name", name).findFirst();
        if (playerRealmQuery == null) {
            highScore.setText("High Score :" + String.valueOf(scores));
            realm.beginTransaction();
            try {
                Player player = realm.createObject(Player.class, name);
                player.setHighScore(Integer.parseInt(scores));
                realm.commitTransaction();
            } catch (Exception ex) {
                realm.cancelTransaction();
                Toast.makeText(mContext, "Failure" + ex, Toast.LENGTH_SHORT).show();
            }
        } else {
            mPlayers = realm.where(Player.class).equalTo("name", name).findAll();

        }

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
