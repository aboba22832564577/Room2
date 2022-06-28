package com.geektech.room2.util;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.geektech.room2.entity.Case;

import java.util.List;

@Dao
public interface CaseDao         {

    @Insert
    void insert(Case item);



    @Query("SELECT * FROM `case`")
    List<Case> getAll();

}
