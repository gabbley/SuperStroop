package com.example.baniquedg.superstroop;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class StroopGameHackBI extends AppCompatActivity {

    //fields
    public static String stroopCompare;
    public static String stroopWord;
    public static int[] colorArray;
    public static int score;
    public TextView mainWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stroop_game);

        initialSetup(); //sets initial layouts/settings
        programmerInfo(); //logs programmer info to console
    }

    public void initialSetup(){

        //sets main word to random color (text and color)
        mainWord = (TextView) findViewById(R.id.lblWord);
        mainWord.setTextColor(randColor());
        mainWord.setText(getRandColorWord());

        //identifies which word is displayed
        stroopWord = mainWord.getText().toString();

        //sets initial score to zero
        score = 0;

        //adds color effect to title on game screen
        TextView gameTitle = (TextView) findViewById(R.id.lblTitle);
        discoTitle(gameTitle);

    }

    public void setStroop(View view){
        whichButtonClicked(view); //identifies which button is chosen

        //colorNameArray(); //sets Stroop Compare
        if (stroopWord.equals(stroopCompare)) { //compares the two answers
            scoreUpdate(); //updates score accordingly
        }

        //plays sound every time button is clicked
        MediaPlayer click = MediaPlayer.create(this, R.raw.click);
        click.start();
    }

    //returns a random color to set word to
    public int randColor(){

        colorArray = new int[] {Color.YELLOW, Color.GREEN,
                Color.RED, Color.BLUE, Color.MAGENTA, Color.BLACK,
                Color.CYAN, Color.WHITE};

        return colorArray[(int)(Math.random() * colorArray.length) ]; //error, thinks length is zero
    }

 //displays score on screen
 public void viewScore(){
     TextView scoreView = (TextView) findViewById(R.id.lblScore);
     String s = ""+ score;
     char[] c = new char[s.length()];
     for (int i = 0; i<s.length(); i++){
         c[i] = s.charAt(i);
     }
     scoreView.setText("" + s);
 }

    //overrides setText method, String parameter instead of char[]
    public char[] setText(String s){
        char[] c = new char[s.length()];

        for (int i = 0; i<s.length(); i++){
            c[i] = s.charAt(i);
        }

        return c;

    }

    //randomly changes text view color every .5 second
    public void discoTitle(final TextView disco){
        Thread t = new Thread() {


            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(500);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                disco.setTextColor(randColor());
                            }
                        });
                    }
                } catch (InterruptedException e) {
                }
            }
        };

        t.start();
    }

//opens settings screen
    public void settingsScreen(View view){
        Class settings = StroopSettings.class;
        Intent intent = new Intent(this, settings);
        startActivity(intent);
    }

//identifies which button is clicked
    public void whichButtonClicked(View view) {
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

    //returns random color name
    public void colorNameArray(){


        String[] colorNames = new String[] {"yellow", "green", "blue", "orange",
                "red", "purple", "pink", "black"};

      stroopWord = colorNames[(int)(Math.random()*colorNames.length)];


    }

    //returns random color
    public String getRandColorWord(){
        String[] colorNames = new String[] {"yellow", "green", "blue", "orange",
                "red", "purple", "pink", "black"};

        return colorNames[(int)(Math.random()*colorNames.length)];
    }

    //updates score, new word
    public void scoreUpdate(){
        score++; //updates score
        viewScore(); //displays score
        mainWord.setTextColor(randColor()); //sets rand color
        colorNameArray(); //sets rand color name
        mainWord.setText(stroopWord); //displays new word

    }

    //resets score to zero
    public void resetScore(View view){
        score = -1;
        scoreUpdate();
        MediaPlayer reset = MediaPlayer.create(this, R.raw.reset);
        reset.start();
    }

//prints programmer info to the log
    public void programmerInfo(){

        Log.i("tag", "Programmed by: Gabby Baniqued");
    }
}
