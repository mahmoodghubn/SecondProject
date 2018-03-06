package com.example.android.americanfootball;

import android.graphics.Color;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int score1 = 0;
    private int score2 = 0;
    private int down1 = 0;
    private int down2 = 0;
    private TextView downsCounter1;
    private TextView downsCounter2;
    private TextView team1Score;
    private TextView team2Score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        downsCounter2 = (TextView) findViewById(R.id.downsCounter2);
        downsCounter1 = (TextView) findViewById(R.id.downsCounter1);
        team1Score = (TextView) findViewById(R.id.team1Score);
        team2Score = (TextView) findViewById(R.id.team2Score);
    }
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("AScore", score1);
        savedInstanceState.putInt("BScore", score2);
        savedInstanceState.putInt("ADown", down1);
        savedInstanceState.putInt("BDown", down2);
    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        if (savedInstanceState != null) {
            score1 = savedInstanceState.getInt("AScore");
            score2 = savedInstanceState.getInt("BScore");
            down1 = savedInstanceState.getInt("ADown");
            down2 = savedInstanceState.getInt("BDown");
        }
        setDowns1(down1);
        setDowns2(down2);
        displayScoreForTeam1(score1);
        displayScoreForTeam2(score2);

    }

    private void displayScoreForTeam1(int score) {

        team1Score.setText(String.valueOf(score));

    }

    private void displayScoreForTeam2(int score) {
        team2Score.setText(String.valueOf(score));

    }

    public void dispalyDowns1(View v) {
        if (down1 < 4)
            down1 = down1 + 1;
        else {
            score2 = score2 + 2;
            displayScoreForTeam2(score2);
            down1 = 0;
            Toast.makeText(getBaseContext(),  getString(R.string.team2_safty), Toast.LENGTH_LONG).show();
        }
        setDowns1(down1);
    }

    public void dispalyDowns2(View v) {
        if (down2 < 4)
            down2 = down2 + 1;
        else {
            score1 = score1 + 2;
            displayScoreForTeam1(score1);
            down2 = 0;
            Toast.makeText(getBaseContext(),  getString(R.string.team1_safty), Toast.LENGTH_LONG).show();
        }
        setDowns2(down2);
    }


    public   void touchdown1(View v) {
        score1 = score1 + 6;
        setDowns1(down1);
        displayScoreForTeam1(score1);
    }

    public void touchdown2(View v) {
        score2 = score2 + 6;
        setDowns2(down2);
        displayScoreForTeam2(score2);
    }

    public void onePointForTeam1(View v) {

        score1 = score1 + 1;
        displayScoreForTeam1(score1);
    }

    public void onePointForTeam2(View v) {

        score2 = score2 + 1;
        displayScoreForTeam2(score2);
    }

    public void twoPointForTeam1(View v) {

        score1 = score1 + 2;
        displayScoreForTeam1(score1);
    }

    public void twoPointForTeam2(View v) {
        score2 = score2 + 2;
        displayScoreForTeam2(score2);
    }


    public void fieldGoal1(View v) {
        score1 = score1 + 3;
        setDowns1(down1);
        displayScoreForTeam1(score1);
    }

    public void fieldGoal2(View v) {
        score2 = score2 + 3;
        setDowns2(down2);
        displayScoreForTeam2(score2);
    }


    public void reset(View v) {
        score1 = 0;
        score2 = 0;
        down1 = 0;
        down2 = 0;
        setDowns1(0);
        setDowns2(0);
        displayScoreForTeam1(0);
        displayScoreForTeam2(0);
    }

    public void setZeroDowns1(View v) {
        down1 = 0;
        downsCounter1.setText(String.valueOf(0));
    }

     public void setZeroDowns2(View v) {
        down2 = 0;
        downsCounter2.setText(String.valueOf(0));
    }


    private void setDowns1(int downsNumber) {
        downsCounter1.setText(String.valueOf(downsNumber));
    }

    private void setDowns2(int downsNumber) {
        downsCounter2.setText(String.valueOf(downsNumber));
    }


}
