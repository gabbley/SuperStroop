package com.example.baniquedg.superstroop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;

public class StroopSettings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stroop_settings);

        createEasyButtons();
    }

    //creates 4 easy buttons
    public void createEasyButtons() {
        Button yellow = (Button) findViewById(R.id.btnYellow);
        Button blue = (Button) findViewById(R.id.btnBlue);
        Button green = (Button) findViewById(R.id.btnGreen);
        Button red = (Button) findViewById(R.id.btnYellow);
    }

    public void createHardButtons(){
        GridLayout hardGrid = (GridLayout) findViewById(R.id.hardButtonsGrid);
        hardGrid.setVisibility(View.VISIBLE);
        Button purple = (Button) findViewById(R.id.btnPurple);
        Button pink = (Button) findViewById(R.id.btnPink);
        Button black = (Button) findViewById(R.id.btnBlack);
        Button orange = (Button) findViewById(R.id.btnOrange);
    }
}
