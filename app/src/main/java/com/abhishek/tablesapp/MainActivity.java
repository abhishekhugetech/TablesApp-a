package com.abhishek.tablesapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // Initializing the List view so that we can use it in our method that we create.
     ListView timeTableListView;

     // Creating the method for generating table for each progess bar change.
    public void generateTimeTableContents(int timeTableTableNumber){
        ArrayList<String> timeTableContents = new ArrayList<String>();
        for(int start = 1;start < 11;start++){
            timeTableContents.add(Integer.toString(timeTableTableNumber*start));
        }

        ArrayAdapter<String>  arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,timeTableContents);

        timeTableListView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Selecting the Seekbar
        final SeekBar timeTableSeekBar = (SeekBar) findViewById(R.id.tablesSeekBar);
        // Setting the value inside the  listView  variable
        timeTableListView = (ListView) findViewById(R.id.tablesListView);

        // Setting max for the tables like 20 for the table
        timeTableSeekBar.setMax(50);
        // Setting Default table to 10
        timeTableSeekBar.setProgress(10);
        // Setting on seekbar change listener
        timeTableSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // Creating a local variable to set the value of progress into it
                int timeTableTableNumber;
                int min = 1;
                // If min is Reached set the value of progress bar to minimum value but not 0 & set the Variable to the Minimum value
                if(progress<min){
                    timeTableSeekBar.setProgress(min);
                    timeTableTableNumber = min;
                }else{
                    // Else set the value of the variable to the progress
                    timeTableTableNumber = progress;
                }
                // Use the method to create table on each time the progress bar is changed.
                generateTimeTableContents(timeTableTableNumber);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        // Default table generation for the App (In this case it is 10)
        generateTimeTableContents(10);
    }
}
