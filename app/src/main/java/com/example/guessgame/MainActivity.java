package com.example.guessgame;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity {
    SharedPreferences mSharedPreferences;
    Context mContext = this;
    public static String ab = "PLAYER_NAME";
    EditText Player_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Player_name = findViewById(R.id.editText);
        mSharedPreferences = mContext.getSharedPreferences(ab, MODE_PRIVATE);
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString("name", Player_name.getText().toString());
    }
    public void AnimalButtonPressed(View view)
    {
        if (TextUtils.isEmpty(Player_name.getText().toString())) {
            Toast.makeText(mContext, "Player name cannot be left empty!!", Toast.LENGTH_SHORT).show();
        } else {
            enterData();
            Intent intent = new Intent(this, AnimalActivity.class);
            startActivity(intent);
        }

    }
    public void PlantButtonPressed(View view)
    {
        if (TextUtils.isEmpty(Player_name.getText().toString())) {
            Toast.makeText(mContext, "Player name cannot be left empty!!", Toast.LENGTH_SHORT).show();
        } else {
            enterData();
            Intent intent = new Intent(this, GameActivity.class);
            startActivity(intent);
        }

    }

    public void enterData() {
        mSharedPreferences = mContext.getSharedPreferences(ab, MODE_PRIVATE);
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString("name", Player_name.getText().toString());
        editor.apply();
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        moveTaskToBack(true);
    }
}
