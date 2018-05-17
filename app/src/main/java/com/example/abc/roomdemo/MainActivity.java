package com.example.abc.roomdemo;

import android.arch.persistence.room.Room;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.abc.roomdemo.Tables.University;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatabaseAsync databaseAsync = (DatabaseAsync) new DatabaseAsync(this,SampleDatabase.getSampleDatabase(this)).execute();
    }


}
