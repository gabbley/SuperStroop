package com.example.baniquedg.superstroop;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class StroopSettings extends AppCompatActivity {

    public CheckBox soundOn;
    public CheckBox soundOff;
    public CheckBox zen;
    public CheckBox timed;
    public CheckBox easy;
    public CheckBox hard;
    public static int[] colorArray;
    public int currentlyChecked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stroop_settings);

        //at 4 colors by default, always visible
        createEasyButtons();
        TextView settingsTitle = (TextView) findViewById(R.id.lblStartTitle);
        discoTitle(settingsTitle);

        //if "hard" mode is chosen, makes extra buttons visible
        RadioButton eightColors = (RadioButton) findViewById(R.id.rbnHard);
        if (eightColors.isChecked()) {
            createHardButtons();
        }



    }



    //creates 4 easy buttons
    public void createEasyButtons() {
        Button yellow = (Button) findViewById(R.id.btnYellow);
        Button blue = (Button) findViewById(R.id.btnBlue);
        Button green = (Button) findViewById(R.id.btnGreen);
        Button red = (Button) findViewById(R.id.btnRed);
    }

    //creates the "hard" buttons, makes visible
    public void createHardButtons() {
        GridLayout hardGrid = (GridLayout) findViewById(R.id.hardButtonsGrid);
        hardGrid.setVisibility(View.VISIBLE);
        Button purple = (Button) findViewById(R.id.btnPurple);
        Button pink = (Button) findViewById(R.id.btnPink);
        Button black = (Button) findViewById(R.id.btnBlack);
        Button orange = (Button) findViewById(R.id.btnOrange);
    }

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

    //returns a random color to set word to
    public int randColor(){

        colorArray = new int[] {Color.YELLOW, Color.GREEN,
                Color.RED, Color.BLUE, Color.MAGENTA, Color.BLACK};

        return colorArray[(int)(Math.random() * colorArray.length) ];
    }


}
