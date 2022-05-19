package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        
        /*테스트를 위한 더미데이터*/
        ArrayList<String> testDataSet = new ArrayList<>();
        for(int i = 0; i<20; i++){
            testDataSet.add("Test Data" + i );
        }
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager((Context) this);
        recyclerView.setLayoutManager(linearLayoutManager); //layout매니저 설정

        CustomAdapter customAdapter = new CustomAdapter(testDataSet);
        recyclerView.setAdapter(customAdapter);


    }
}