package com.geektech.room2.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import com.geektech.room2.R;
import com.geektech.room2.entity.Case;
import com.geektech.room2.util.AppDB;
import com.geektech.room2.util.CaseDao;

import java.util.Date;
import java.util.Locale;

public class CaseActivity extends AppCompatActivity {


    String date = new SimpleDateFormat("dd.MM.yyyy   HH:mm", Locale.getDefault()).format(new Date());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case);

        Intent intent = getIntent();

        String nameBD = "dataBase";
        AppDB appDB = Room.databaseBuilder(getApplicationContext(),AppDB.class,nameBD).allowMainThreadQueries().build();

        CaseDao caseDao = appDB.caseDao();


        EditText editCaseText2 = (EditText) findViewById(R.id.editCaseText2);
        EditText editCaseText = (EditText) findViewById(R.id.editCaseText);
        Button saveButton = (Button) findViewById(R.id.saveButton);


        saveButton.setOnClickListener(view -> {
            Case newItem = new Case();
            newItem.text = String.valueOf(editCaseText.getText());
            newItem.description = String.valueOf(editCaseText2.getText());
            newItem.date = date;
            caseDao.insert(newItem);
            setResult(RESULT_OK);
            finish();
        });



    }
}