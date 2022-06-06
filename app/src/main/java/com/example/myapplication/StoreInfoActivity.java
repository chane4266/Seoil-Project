package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StoreInfoActivity extends AppCompatActivity implements View.OnClickListener{
    private View menu;
    private View review;

    Button menu_button, review_button;
    TextView txtstore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_info);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        init();

        menu_button = findViewById(R.id.Button_Menu);
        review_button = findViewById(R.id.Button_Review);
        txtstore = findViewById(R.id.textView_StoreInfo);

        menu_button.setOnClickListener(this);
        review_button.setOnClickListener(this);

        Intent intent = getIntent();

        txtstore.setText(intent.getStringExtra("title"));

    }
    public void init(){

        menu = findViewById(R.id.menu_scroll);
        review = findViewById(R.id.review_scroll);

    }
    @Override
    public void onClick(View view) {
        switch(view.getId()){
            //스탬프 뷰만보이기
            case R.id.Button_Menu:
                menu.setVisibility(View.VISIBLE);
                review.setVisibility(View.INVISIBLE);
                break;

            case R.id.Button_Review:
                menu.setVisibility(View.INVISIBLE);
                review.setVisibility(View.VISIBLE);
                break;

        }
    }
}