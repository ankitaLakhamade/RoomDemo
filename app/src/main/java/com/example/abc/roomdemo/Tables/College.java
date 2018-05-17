package com.example.abc.roomdemo.Tables;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by abc on 4/10/2018.
 */


@Entity(foreignKeys = @ForeignKey(entity = University.class, parentColumns = "slno", childColumns = "university_Id"))
public class College {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    @ColumnInfo(name = "university_Id")
    private long university_Id;


    public int getId() {
        return id;
    }

    public long getUniversity_Id() {
        return university_Id;
    }

    public void setUniversity_Id(long university_Id) {
        this.university_Id = university_Id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
