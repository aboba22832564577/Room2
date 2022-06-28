package com.geektech.room2.util;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.geektech.room2.entity.Case;

@Database(entities = {Case.class}, version = 1)
public abstract class AppDB extends RoomDatabase {
    public abstract CaseDao caseDao();
}
