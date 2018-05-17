package com.example.abc.roomdemo;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.abc.roomdemo.Tables.University;

import java.util.List;

/**
 * Created by abc on 4/10/2018.
 */

@Dao
public interface DaoUniversity {

    @Insert
    void insertMultipleRecords(University... universities);

    @Insert
    void insertMultipleListRecords(List<University> universities);

    @Insert
    void insertSingleRecord(University university);

    @Query("select * from University")
    List<University> fetchAllData();

    @Update
    void updateRecord(University university);

    @Delete
    void deleteRecord(University university);

}
