package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MyPageActivity extends AppCompatActivity implements View.OnClickListener{

    private View firstView; //스탬프
    private View secondView; //즐겨찾기
    private View thirdView; //내리뷰

    Button btn01, btn02, btn03;
    ImageButton btnSetting;
    RecyclerView fa_list;
    StoreListAdapter list_adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_page);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        init();

        btn01 = findViewById(R.id.sBtn);
        btn02 = findViewById(R.id.jBtn);
        btn03 = findViewById(R.id.rBtn);
        btnSetting = findViewById(R.id.settingBtn);

        btn01.setOnClickListener(this);
        btn02.setOnClickListener(this);
        btn03.setOnClickListener(this);
        btnSetting.setOnClickListener(this);

        fa_list = findViewById(R.id.favorite_list);
        LinearLayoutManager lM = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL, false);
        fa_list.setLayoutManager(lM);

        list_adapter = new StoreListAdapter(getApplicationContext());
        fa_list.setAdapter(list_adapter);

        list_adapter.addItem(new StoreListitem(R.drawable.moms,"맘스터치","서일대점","4.3"));
        list_adapter.addItem(new StoreListitem(R.drawable.gomtang,"닭곰탕","서일대점","4.7"));
        list_adapter.addItem(new StoreListitem(R.drawable.cheese,"치즈밥","서일대점","4.4"));
        list_adapter.addItem(new StoreListitem(R.drawable.gg_go,"지지고","서일대점","4.9"));
        list_adapter.addItem(new StoreListitem(R.drawable.s_pork,"모두랑","서일대점","3.8"));
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
            if(view.getId() == R.id.settingBtn){
                Intent Setting1 = new Intent(this, SettingActivity.class);
                startActivity(Setting1);
            }
        }
    }
