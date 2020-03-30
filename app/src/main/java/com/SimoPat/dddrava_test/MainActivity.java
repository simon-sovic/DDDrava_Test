package com.SimoPat.dddrava_test;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;


public class MainActivity extends AppCompatActivity {

    private Float score;
    private Boolean add;
    private Float amount;
    private Float amountMin;
    private Float amountMax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Seštemnožilnik 3001.5");

        score = 1f;
        add = false;
        amount = 1.1f;
        amountMin = 0.1f;
        amountMax = 10f;

        // Find views
        Button addScoreButton = findViewById(R.id.addScoreButton);
        Switch addSwitch = findViewById(R.id.addSwitch);
        Button upButton = findViewById(R.id.upButton);
        Button downButton = findViewById(R.id.downButton);

        // Assign listeners
        addScoreButton.setOnClickListener(addScoreButton_OnClickListener);
        addSwitch.setOnClickListener(addSwitch_OnClickListener);
        upButton.setOnClickListener(upButton_OnClickListener);
        downButton.setOnClickListener(downButton_OnClickListener);
    }


    // Main button listener
    private View.OnClickListener addScoreButton_OnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            score = (add) ? score + amount : score * amount;
            updateTexts();
        }
    };

    // Switch listener
    private View.OnClickListener addSwitch_OnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Switch addSwitch = findViewById(R.id.addSwitch);
            add = addSwitch.isChecked();
            updateTexts();
        }
    };

    // Up button listener
    private View.OnClickListener upButton_OnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (amount >= amountMax) return;
            amount += 0.1f;
            amount = Math.round(amount * 10f) / 10.0f;
            updateTexts();
        }
    };

    // Down button listener
    private View.OnClickListener downButton_OnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (amount <= amountMin) return;
            amount -= 0.1f;
            amount = Math.round(amount * 10f) / 10.0f;
            updateTexts();
        }
    };


    private void updateTexts() {
        // Find views
        Button addScoreButton = findViewById(R.id.addScoreButton);
        Switch addSwitch = findViewById(R.id.addSwitch);
        TextView scoreText = (TextView) findViewById(R.id.scoreText);

        // Convert numbers to strings
        String amountString = String.valueOf(amount).replace('.', ',');
        String scoreString = String.valueOf(score).replace('.', ',');

        // Set texts
        addScoreButton.setText((add) ? "Prištej " + amountString : "Pomnoži z " + amountString);
        String addSwitchText = "Prištej " + amountString;
        addSwitch.setText(addSwitchText);
        scoreText.setText(scoreString);
    }

}
