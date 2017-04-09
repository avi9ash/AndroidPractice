package com.example.android.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayForTeamA(10);
    }
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }
    public void buttonForThree(View view)
    {
        displayForTeamA(3);
    }
    public void buttonForTwo(View view)
    {
        displayForTeamA(2);
    }
    public void buttonForFreeThrow(View view)
    {
        displayForTeamA(1);
    }
}