package com.example.abc.roomdemo;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.abc.roomdemo.Tables.College;
import com.example.abc.roomdemo.Tables.University;

/**
 * Created by abc on 4/9/2018.
 */

@Database(entities = {University.class, College.class},version = 1)
public abstract class SampleDatabase extends RoomDatabase {
    private static SampleDatabase INSTANCE;

    public abstract DaoCollege daoCollege();
    public abstract DaoUniversity daoUniversity();

  public static SampleDatabase getSampleDatabase(Context context)
  {
      if(INSTANCE==null)
      {
          INSTANCE= Room.databaseBuilder(context.getApplicationContext(),
                  SampleDatabase.class,"University-database").allowMainThreadQueries().build();

      }
      return INSTANCE;

  }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}
