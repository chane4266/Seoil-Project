package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MyPageActivity extends AppCompatActivity implements View.OnClickListener{

    private View firstView; //스탬프
    private View secondView; //즐겨찾기
    private View thirdView; //내리뷰

    Button btn01, btn02, btn03;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_page);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        init();

        btn01 = findViewById(R.id.sBtn);
        btn02 = findViewById(R.id.jBtn);
        btn03 = findViewById(R.id.rBtn);

        btn01.setOnClickListener(this);
        btn02.setOnClickListener(this);
        btn03.setOnClickListener(this);
    }

    public void init(){
        firstView = findViewById(R.id.sView);
        secondView = findViewById(R.id.jView);
        thirdView = findViewById(R.id.rView);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            //스탬프 뷰만보이기
            case R.id.sBtn :
                firstView.setVisibility(View.VISIBLE);
                secondView.setVisibility(View.INVISIBLE);
                thirdView.setVisibility(View.INVISIBLE);
                break;

            case R.id.jBtn :
                firstView.setVisibility(View.INVISIBLE);
                secondView.setVisibility(View.VISIBLE);
                thirdView.setVisibility(View.INVISIBLE);
                break;

            case R.id.rBtn :
                firstView.setVisibility(View.INVISIBLE);
                secondView.setVisibility(View.INVISIBLE);
                thirdView.setVisibility(View.VISIBLE);
                break;
            }
        }
    }
