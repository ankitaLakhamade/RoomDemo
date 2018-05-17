package com.example.abc.roomdemo;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.abc.roomdemo.Tables.College;

import java.util.List;

/**
 * Created by abc on 4/10/2018.
 */

@Dao
public interface DaoCollege {

    @Insert
    void insertRec(List<College> colleges);

    @Update
    void update(College college);

    @Delete
    void delete(College colleges);

    @Query("select * from College")
    List<College> fetchAllData();

    @Query("SELECT * FROM College WHERE university_Id=:university_Id")
    List<College> findRepositoriesForUser(final int university_Id);
}
