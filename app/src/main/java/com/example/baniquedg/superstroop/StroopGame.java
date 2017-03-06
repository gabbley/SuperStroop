package com.example.baniquedg.superstroop;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

public class StroopGame extends AppCompatActivity {

    //fields
    public static String stroopGuess;
    public static String stroopCompare;
    public static Button currentClick;
    public static int[] colorArray;
    public static int score;
    public TextView mainWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stroop_game);
        mainWord = (TextView) findViewById(R.id.lblWord);
        mainWord.setTextColor(randColor());
        score = 0;
       // checkErr(); //checks if the colors are not working

    }

    public void setStroop(View view){
        stroopWordColor(); //identifies current mainWord color
        //whichButtonClicked(view); //identifies which button is chosen
        colorNameArray(); //sets Stroop Compare
        if (stroopGuess.equals(stroopCompare)) { //compares the two answers
            scoreUpdate(); //updates score accordingly
        }
    }

    //returns a random color to set word to
    public int randColor(){

        colorArray = new int[] {Color.YELLOW, Color.GREEN,
                Color.RED, Color.BLUE, Color.MAGENTA, Color.BLACK};

        return colorArray[(int)(Math.random() * colorArray.length) ]; //error, thinks length is zero
    }

 public void viewScore(){
     TextView scoreView = (TextView) findViewById(R.id.lblScore);
     String s = ""+ score;
     char[] c = new char[s.length()];
     for (int i = 0; i<s.length(); i++){
         c[i] = s.charAt(i);
     }
     scoreView.setText("" + 0);

     //scoreView.setText(c, 0, s.length());
 }

    public char[] setText(String s){
        char[] c = new char[s.length()];

        for (int i = 0; i<s.length(); i++){
            c[i] = s.charAt(i);
        }

        return c;

    }

    //button.getText().toString() compare this to color called below

    public void stroopWordColor(){
        switch (mainWord.getCurrentTextColor()){
            case Color.YELLOW : stroopGuess = "yellow";
                break;
            case Color.GREEN : stroopGuess = "green";
                break;
            case Color.RED : stroopGuess = "red";
                break;
            case Color.BLUE : stroopGuess = "blue";
                break;
          //  case Color.VERY_DARK_MAGENTA : color = "purple";
            case Color.BLACK : stroopGuess = "black";
                break;
               // case Color.ORA
            case Color.MAGENTA: stroopGuess = "pink";
                break;
            default : stroopGuess = "no color";
        }
    }


    /*public void whichButtonClicked(View view) {
            switch (view.getId()) {
                case R.id.btnYellow: stroopCompare = "yellow";
                    break;
                case R.id.btnGreen: stroopCompare = "green";
                    break;
                case R.id.btnRed : stroopCompare = "red";
                    break;
                case R.id.btnBlue : stroopCompare = "blue";
                    break;
                case R.id.btnPurple : stroopCompare = "purple";
                    break;
                case R.id.btnBlack : stroopCompare = "black";
                    break;
                case R.id.btnOrange : stroopCompare = "orange";
                    break;
                case R.id.btnPink : stroopCompare = "pink";
                    break;
                default: stroopCompare = "no color";
            }
        }
*/
    public void colorNameArray(){


        String[] colorNames = new String[] {"yellow", "green", "blue", "orange",
                "red", "purple", "pink", "black"};

      stroopCompare = colorNames[(int)(Math.random()*colorNames.length)];



    }

    public void checkErr(){
        if (stroopCompare.equals("no color") || stroopGuess.equals("no color")){
            //error message in dialog box
        }
    }

    public void scoreUpdate(){
        score++;
        viewScore();
        mainWord.setTextColor(randColor());
        colorNameArray();
        mainWord.setText(stroopCompare); //override the method?

    }

    public void resetScore(View view){
        score = -1;
        scoreUpdate();

    }
}
