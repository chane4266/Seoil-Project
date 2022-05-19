package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.provider.ContactsContract;

import java.util.ArrayList;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    RecyclerView StoreList_list;
    StoreListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        StoreList_list = findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL, false);
        StoreList_list.setLayoutManager(layoutManager);

        adapter = new StoreListAdapter(getApplicationContext());
        StoreList_list.setAdapter(adapter);

        adapter.addItem(new StoreListitem(R.drawable.ddug,"서일분식","서일대점"));
        adapter.addItem(new StoreListitem(R.drawable.moms,"맘스터치","서일대점"));
        adapter.addItem(new StoreListitem(R.drawable.gomtang,"닭곰탕","서일대점"));
    }


}