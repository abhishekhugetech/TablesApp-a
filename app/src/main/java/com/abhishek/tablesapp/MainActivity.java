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

     ListView timeTableListView;

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

        final SeekBar timeTableSeekBar = (SeekBar) findViewById(R.id.tablesSeekBar);
        timeTableListView = (ListView) findViewById(R.id.tablesListView);

        timeTableSeekBar.setMax(20);
        timeTableSeekBar.setProgress(10);
        timeTableSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int timeTableTableNumber;
                int min = 1;
                if(progress<min){
                    timeTableSeekBar.setProgress(min);
                    timeTableTableNumber = min;
                }else{
                    timeTableTableNumber = progress;
                }

                generateTimeTableContents(timeTableTableNumber);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        generateTimeTableContents(10);
    }
}
