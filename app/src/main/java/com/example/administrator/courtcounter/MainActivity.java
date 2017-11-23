package com.example.administrator.courtcounter;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int mScoreTeamA = 0;
    int mScoreTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_port);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.activity_main_land);
            displayForTeamA(mScoreTeamA);
            displayForTeamB(mScoreTeamB);
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            setContentView(R.layout.activity_main_port);
            displayForTeamA(mScoreTeamA);
            displayForTeamB(mScoreTeamB);
        }
    }

    /**
     * This method is called when the "+3 points" button is clicked.
     */
    public void plusThreePoints(View view) {
        if (view.getId() == R.id.button_plus_3_points_team_a) {
            mScoreTeamA += 3;
            displayForTeamA(mScoreTeamA);
        } else {
            mScoreTeamB += 3;
            displayForTeamB(mScoreTeamB);
        }
    }


    /**
     * This method is called when the "+2 points" button is clicked.
     */
    public void plusTwoPoints(View view) {
        if (view.getId() == R.id.button_plus_2_points_team_a) {
            mScoreTeamA += 2;
            displayForTeamA(mScoreTeamA);
        } else {
            mScoreTeamB += 2;
            displayForTeamB(mScoreTeamB);
        }

    }

    /**
     * This method is called when the FreeThrow button is clicked.
     */
    public void freeThrow(View view) {
        if (view.getId() == R.id.button_free_throw) {
            mScoreTeamA += 1;
            displayForTeamA(mScoreTeamA);
        } else {
            mScoreTeamB += 1;
            displayForTeamB(mScoreTeamB);
        }

    }

    /**
     * This method is called when the Reset button is clicked.
     */
    public void reset(View view) {
        mScoreTeamA = 0;
        mScoreTeamB = 0;
        displayForTeamA(mScoreTeamA);
        displayForTeamB(mScoreTeamB);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

}
