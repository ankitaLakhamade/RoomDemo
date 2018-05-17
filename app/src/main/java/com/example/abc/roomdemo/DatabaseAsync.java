package com.example.abc.roomdemo;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.util.Log;

import com.example.abc.roomdemo.Tables.College;
import com.example.abc.roomdemo.Tables.University;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abc on 4/9/2018.
 */

public class DatabaseAsync extends AsyncTask<Void, Integer, Void> {
    SampleDatabase database;
    Context context;
    ProgressDialog progress;

    public DatabaseAsync(Context context, SampleDatabase database) {
        this.database = database;
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        progress = new ProgressDialog(context);
        progress.setCancelable(true);
        progress.setMessage("Inserting...");
        progress.setCanceledOnTouchOutside(false);
        progress.setProgressStyle(progress.STYLE_HORIZONTAL);
        // progress.setMax(10);
        progress.show();
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        if (progress != null)
            progress.dismiss();
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        progress.setProgress(values[0]);
    }

    @Override
    protected Void doInBackground(Void... voids) {
        College college = new College();
        University university = new University();
        List<College> colleges;
        List<University> universities;
        colleges = new ArrayList<>();
        universities = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            college.setName("Garware");
            college.setUniversity_Id(1);
            colleges.add(college);

            university.setName("SPPU");
            university.setAddress("Pune");
            universities.add(university);

            SystemClock.sleep(1000);
            onProgressUpdate(i * 10);
        }
        database.daoCollege().insertRec(colleges);
        Log.d(";;;", database.daoCollege().fetchAllData().toString());
        database.daoUniversity().insertMultipleListRecords(universities);

        return null;
    }


}
