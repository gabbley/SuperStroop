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
    public static int whichColor = 0;
    public TextView mainWord = (TextView) findViewById(R.id.lblWord);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stroop_game);



    }

    public void setStroop(View view){
        stroopGuess = stroopWordColor();
    }

/*    public String chooseColor(){
        String color;

        switch (whichColor){
            case 1: color = "yellow";
                break;
            case 2: color = "green";
                break;
            case 3: color = "red";
                break;
            case 4: color = "blue";
                break;
            case 5: color = "purple";
                break;
            case 6: color = "black";
                break;
            case 7: color = "orange";
                break;
            case 8: color = "pink";
                break;
            default: color = "n/a";
                break;
        }

        return color;
    }*/

    public String stroopWordColor(){
        if (mainWord.getCurrentTextColor() == Color.YELLOW){
            whichColor = 0;
        }

    }


}
