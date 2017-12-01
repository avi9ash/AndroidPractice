package com.example.android.sample1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void printToLogs(View view) {
        Log.i("Trying out ","Logging information");
        // Find first menu item TextView and print the text to the logs

        // Find second menu item TextView and print the text to the logs

        // Find third menu item TextView and print the text to the logs

    }
}