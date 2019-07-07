package com.example.guessgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class GameActivity extends AppCompatActivity {
    static int count=0,guess=5;
    private Button opt[]=new Button[4];
    private ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        img=findViewById(R.id.imageView);
        opt[0]=findViewById(R.id.option1);
        opt[1]=findViewById(R.id.option2);
        opt[2]=findViewById(R.id.option3);
        opt[3]=findViewById(R.id.option4);
        final int arr[]={
                R.drawable.bluebell,
                R.drawable.bougainvillea,
                R.drawable.cherry_blossom,
                R.drawable.daffodils,
                R.drawable.dahlia,
                R.drawable.daisy,
                R.drawable.dandelion,
                R.drawable.hibiscus,
                R.drawable.hyacinth,
                R.drawable.iris,
                R.drawable.jasmine,
                R.drawable.lavender,
                R.drawable.lily,
                R.drawable.lotus,
                R.drawable.magnolia,
                R.drawable.marigold,
                R.drawable.pansy,
                R.drawable.petunia,
                R.drawable.plumeria,
                R.drawable.poppy_flower,
                R.drawable.rafflesia,
                R.drawable.rose,
                R.drawable.sunflower,
                R.drawable.tiger_lily,
                R.drawable.tulip

            };
        String name[]={
                "Bluebell",
                "Bougainvillea",
                "Cherry Blossom",
                "Daffodil",
                "Dahlia",
                "Daisy",
                "Dandelion",
                "Hibiscus",
                "Hyacinth",
                "Iris",
                "Jasmine",
                "Lavender",
                "Lily",
                "Lotus",
                "Magnolia",
                "Marigold",
                "Pansy",
                "Petunia",
                "Plumeria",
                "Poppy Flower",
                "Rafflesia",
                "Rose",
                "Sunflower",
                "Tiger Lily",
                "Tulip"
        };
        Random random=new Random();
        int n=random.nextInt(25);
        img.setImageResource(arr[n]);
        int temp=arr[24];
        arr[24]=arr[n];
        arr[n]=temp;
        int b=random.nextInt(4);
        opt[b].setText(name[n]);
    }
}
