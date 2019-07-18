
package com.example.guessgame;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class AnimalActivity extends AppCompatActivity {
    private static int count=0;
    private static int guess=5;
    private ImageView img;
    private Button opt[]=new Button[4];
    static int p = 25;
    String answer = "";
    private TextView round, guess_tv;
    private static int corr_ans = 0;
    private static int eve_corr_ans = 0;
    final int[] arr = {
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
    final String name[] = {
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal);
        img=findViewById(R.id.imageView);
        opt[0]=findViewById(R.id.option1);
        opt[1]=findViewById(R.id.option2);
        opt[2]=findViewById(R.id.option3);
        opt[3]=findViewById(R.id.option4);
        round = findViewById(R.id.text_round);
        corr_ans = 0;
        count = 0;
        eve_corr_ans = 0;
        guess = 5;
        guess_tv = findViewById(R.id.text_guess);
        question_answer();
    }

    public void question_answer() {
        count++;
        round.setText("Round " + String.valueOf(count));
        guess_tv.setText("Number of Guesses Left: " + String.valueOf(guess));
        Random random=new Random();
        int n = random.nextInt(p);
        img.setImageResource(arr[n]);
        int b = random.nextInt(4);
        opt[b].setText(name[n]);
        answer = name[n];
        int temp = arr[p - 1];
        arr[p - 1] = arr[n];
        arr[n]=temp;
        String name1 = name[p - 1];
        name[p - 1] = name[n];
        name[n] = name1;
        p--;

        boolean flag;
        for (int i = 0; i < 4; i++) {
            if (i != b) {
                int t;
                while (true) {
                    flag = true;
                    t = random.nextInt(25);
                    for (int j = 0; j < 4; j++) {
                        if (opt[j].getText() == name[t]) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag)
                        break;
                }
                opt[i].setText(name[t]);
            }
        }

    }

    public void onButton1Pressed(View view) {
        if (opt[0].getText().equals(answer)) {
            opt[0].setBackgroundColor(getResources().getColor(R.color.Green));
            eve_corr_ans++;
            if (count < 25) {
                disableButton();
                correctDialog();
            } else {
                endGame();
            }
        } else {
            opt[0].setBackgroundColor(getResources().getColor(R.color.Red));
            if (eve_corr_ans > corr_ans) {
                corr_ans = eve_corr_ans;
                eve_corr_ans = 0;
            }
            guess--;
            wrongDialog();
            if (guess == 0) {
                endGame();
            }
        }

    }

    public void onButton2Pressed(View view) {
        if (opt[1].getText().equals(answer)) {
            opt[1].setBackgroundColor(getResources().getColor(R.color.Green));
            eve_corr_ans++;
            if (count < 25) {
                disableButton();
                correctDialog();
            } else {
                endGame();
            }
        } else {
            opt[1].setBackgroundColor(getResources().getColor(R.color.Red));
            if (eve_corr_ans > corr_ans) {
                corr_ans = eve_corr_ans;
                eve_corr_ans = 0;
            }
            guess--;
            wrongDialog();
            if (guess == 0) {
                endGame();
            }
        }
    }

    public void onButton3Pressed(View view) {
        if (opt[2].getText().equals(answer)) {
            opt[2].setBackgroundColor(getResources().getColor(R.color.Green));
            eve_corr_ans++;
            if (count < 25) {
                disableButton();
                correctDialog();
            } else {
                endGame();
            }
        } else {
            opt[2].setBackgroundColor(getResources().getColor(R.color.Red));
            if (eve_corr_ans > corr_ans) {
                corr_ans = eve_corr_ans;
                eve_corr_ans = 0;
            }
            guess--;
            wrongDialog();
            if (guess == 0) {
                endGame();
            }
        }

    }

    public void onButton4Pressed(View view) {
        if (opt[3].getText().equals(answer)) {
            opt[3].setBackgroundColor(getResources().getColor(R.color.Green));
            eve_corr_ans++;
            if (count < 25) {
                disableButton();
                correctDialog();
            } else {
                endGame();
            }
        } else {
            opt[3].setBackgroundColor(getResources().getColor(R.color.Red));
            if (eve_corr_ans > corr_ans) {
                corr_ans = eve_corr_ans;
                eve_corr_ans = 0;
            }
            guess--;
            wrongDialog();
            if (guess == 0) {

                endGame();
            }
        }
    }

    public void wrongDialog() {
        final Dialog dialogCorrect = new Dialog(AnimalActivity.this);
        dialogCorrect.requestWindowFeature(Window.FEATURE_NO_TITLE);
        if (dialogCorrect.getWindow() != null) {
            ColorDrawable colorDrawable = new ColorDrawable(Color.TRANSPARENT);
            dialogCorrect.getWindow().setBackgroundDrawable(colorDrawable);
        }
        dialogCorrect.setContentView(R.layout.dialog_correct);
        dialogCorrect.setCancelable(false);
        dialogCorrect.show();
        TextView textView = dialogCorrect.findViewById(R.id.correctText);
        Button buttonNext = dialogCorrect.findViewById(R.id.dialogNext);
        textView.setText("WRONG!!");
        textView.setTextColor(getResources().getColor(R.color.Red));
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogCorrect.dismiss();
                question_answer();
                reset_color();
                enableButton();
            }
        });
    }

    public void disableButton() {
        opt[0].setEnabled(false);
        opt[1].setEnabled(false);
        opt[2].setEnabled(false);
        opt[3].setEnabled(false);
    }

    public void enableButton() {
        opt[0].setEnabled(true);
        opt[1].setEnabled(true);
        opt[2].setEnabled(true);
        opt[3].setEnabled(true);
    }

    public void reset_color() {
        opt[0].setBackgroundColor(getResources().getColor(R.color.Button1color));
        opt[1].setBackgroundColor(getResources().getColor(R.color.Button2color));
        opt[2].setBackgroundColor(getResources().getColor(R.color.Button3color));
        opt[3].setBackgroundColor(getResources().getColor(R.color.Button4color));
    }

    public void correctDialog() {
        final Dialog dialogCorrect = new Dialog(AnimalActivity.this);
        dialogCorrect.requestWindowFeature(Window.FEATURE_NO_TITLE);
        if (dialogCorrect.getWindow() != null) {
            ColorDrawable colorDrawable = new ColorDrawable(Color.TRANSPARENT);
            dialogCorrect.getWindow().setBackgroundDrawable(colorDrawable);
        }
        dialogCorrect.setContentView(R.layout.dialog_correct);
        dialogCorrect.setCancelable(false);
        dialogCorrect.show();
        Button buttonNext = dialogCorrect.findViewById(R.id.dialogNext);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogCorrect.dismiss();
                question_answer();
                reset_color();
                enableButton();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void endGame() {
        if (eve_corr_ans > corr_ans)
            corr_ans = eve_corr_ans;
        Intent i = new Intent(this, EndGameActivity.class);
        i.putExtra("scores", String.valueOf(corr_ans));
        startActivity(i);
    }
}