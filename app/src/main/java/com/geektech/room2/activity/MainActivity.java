package com.geektech.room2.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.geektech.room2.entity.Case;
import com.geektech.room2.R;
import com.geektech.room2.util.AppDB;
import com.geektech.room2.util.CaseAdapter;
import com.geektech.room2.util.CaseDao;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView listCase;
    List<Case> list;
    String nameBD = "dataBase";
    AppDB appDB;
    CaseDao caseDao;
    CaseAdapter caseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listCase = findViewById(R.id.listCases);
        appDB = Room.databaseBuilder(getApplicationContext(),AppDB.class,nameBD).
                allowMainThreadQueries().fallbackToDestructiveMigration().build();
        caseDao = appDB.caseDao();
        list = caseDao.getAll();


        listCase.setLayoutManager(new LinearLayoutManager(this));
        caseAdapter = new CaseAdapter(this, list);
        listCase.setAdapter(caseAdapter);

        Button addButton = findViewById(R.id.addButton);


        addButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, CaseActivity.class);
            intent.putExtra("action", "add");
            startActivityForResult(intent, 1);
        });
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1){
            list.clear();
            list.addAll(caseDao.getAll());
            caseAdapter.notifyDataSetChanged();
        }
    }
}