package com.geektech.room2.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Case {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "case_text")
    public String text;

    @ColumnInfo(name = "case_description")
    public String description;

    @ColumnInfo(name = "case_date")
    public String date;

    public Case(String text, String description, String date) {
        this.text = text;
        this.description = description;
        this.date = date;
    }

    public Case(int id, String text, String description, String date) {
        this.id = id;
        this.text = text;
        this.description = description;
        this.date = date;
    }

    public Case() {
    }
}
