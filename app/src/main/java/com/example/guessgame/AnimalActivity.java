package com.example.guessgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class AnimalActivity extends AppCompatActivity {
    private static int count=0;
    private static int guess=5;
    private ImageView img;
    private Button opt[]=new Button[4];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal);
        img=findViewById(R.id.imageView);
        opt[0]=findViewById(R.id.option1);
        opt[1]=findViewById(R.id.option2);
        opt[2]=findViewById(R.id.option3);
        opt[3]=findViewById(R.id.option4);
        final int []arr={
                R.drawable.bear,
                R.drawable.camel,
                R.drawable.crocodile,
                R.drawable.deer,
                R.drawable.donkey,
                R.drawable.elephant,
                R.drawable.fox,
                R.drawable.giraffe,
                R.drawable.hamster,
                R.drawable.hedgehog,
                R.drawable.hippo,
                R.drawable.horse,
                R.drawable.hyena,
                R.drawable.kangaroo,
                R.drawable.koala,
                R.drawable.llama,
                R.drawable.monkey,
                R.drawable.mule,
                R.drawable.panda,
                R.drawable.pig,
                R.drawable.polar_bear,
                R.drawable.rhino,
                R.drawable.tiger,
                R.drawable.turtle,
                R.drawable.weasel
        };
        final String name[]={
                "Bear",
                "Camel",
                "Crocodile",
                "Deer",
                "Donkey",
                "Elephant",
                "Fox",
                "Giraffe",
                "Hamster",
                "Hedgehog",
                "Hippo",
                "Horse",
                "Hyena",
                "Kangaroo",
                "Koala",
                "Llama",
                "Monkey",
                "Mule",
                "Panda",
                "Pig",
                "Polar Bear",
                "Rhino",
                "Tiger",
                "Turtle",
                "Weasel"
        };
        Random random=new Random();
        int n=random.nextInt(25);
        img.setImageResource(arr[n]);
        int temp=arr[24];
        arr[24]=arr[n];
        arr[n]=temp;
        int b=random.nextInt(4);
        opt[b].setText(name[n]);
        count++;
    }
}
