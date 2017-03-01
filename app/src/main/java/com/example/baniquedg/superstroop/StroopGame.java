package com.example.baniquedg.superstroop;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

public class StroopGame extends AppCompatActivity {

    //fields
    public static String stroopGuess = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stroop_game);



    }

    public void setStroop(String color){
        stroopGuess = color;
        TextView word = (TextView) findViewById(R.id.lblScore);
        word.setText(stroopGuess);
    }



}
