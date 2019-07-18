package com.example.guessgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void AnimalButtonPressed(View view)
    {
        Intent intent=new Intent(this,AnimalActivity.class);
        startActivity(intent);
    }
    public void PlantButtonPressed(View view)
    {
        Intent intent=new Intent(this,GameActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
