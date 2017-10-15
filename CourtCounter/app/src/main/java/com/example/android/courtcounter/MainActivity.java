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
        displayForTeamA(scoreA);
        displayForTeamB(scoreB);
    }
    int scoreA=0;
    int scoreB=0;

    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }
    public void buttonForThreeA(View view)
    {
        scoreA+=3;

        displayForTeamA(scoreA);
    }
    public void buttonForTwoA(View view)
    {
        scoreA+=2;
        displayForTeamA(scoreA);
    }
    public void buttonForFreeThrowA(View view)
    {
        scoreA+=1;
        displayForTeamA(scoreA);
    }
    public void buttonForThreeB(View view)
    {
        scoreB+=3;

        displayForTeamB(scoreB);
    }
    public void buttonForTwoB(View view)
    {
        scoreB+=2;
        displayForTeamB(scoreB);
    }
    public void buttonForFreeThrowB(View view)
    {
        scoreB+=1;
        displayForTeamB(scoreB);
    }
    public void reset(View view)
    {
        scoreA=0;
        scoreB=0;
        displayForTeamA(scoreA);
        displayForTeamB(scoreB);
    }
}
