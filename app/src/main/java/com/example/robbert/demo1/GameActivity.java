package com.example.robbert.demo1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;

import java.util.*;

public class GameActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // turn off title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // set the view
        setContentView(R.layout.activity_game);
    }

    public void onQuit(View v) {
        finish();
    }

    TextView error;
    TextView guessedNumber;

    public void onGuess(View v) {
        // two variables to store error message and number that will be displayed (guessed)
        error = (TextView)findViewById(R.id.errorMessage);
        guessedNumber = (TextView)findViewById(R.id.guessedNumber);

        // get min and max text fields
        EditText minNumb = (EditText)findViewById(R.id.minNumb);
        EditText maxNumb = (EditText)findViewById(R.id.maxNumb);

        // check if both of them are filled in
        if(minNumb.getText().toString().length() == 0 || maxNumb.getText().toString().length() == 0) {
            error.setText("Please make sure to fill in both numbers");
            guessedNumber.setText("");
        }
        else {
            int min = Integer.parseInt(minNumb.getText().toString());
            int max = Integer.parseInt(maxNumb.getText().toString());

            // check if max is greater than min, and if they're not negative
            if (min < max && min >= 0 && max >= 0) {
                // set the display text for guessed number
                guessedNumber.setText(randomNumber(min, max));
                error.setText("");

            } else {
                error.setText("Minimum value should be bigger than the maximum");
                guessedNumber.setText("");
            }
        }
    }
    public String randomNumber(int min, int max) {
        Random r = new Random();
        int r1 = r.nextInt(max - min + 1) + min;

        return ""+r1;
    }
}
