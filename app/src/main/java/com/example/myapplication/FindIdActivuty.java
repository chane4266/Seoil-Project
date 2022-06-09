package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FindIdActivuty extends AppCompatActivity implements View.OnClickListener
{
    Button btn_find;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_id_activuty);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        btn_find = (Button) findViewById(R.id.find_id_btn);
        btn_find.setOnClickListener(this);
    }


    @Override
    public void onClick(View view)
    {
        Intent id_intent = new Intent(this,LoginActivity.class);
        if(view.getId() == R.id.find_id_btn)
        {
            // 사용자가 '찾기'버튼을 눌렀을때 메세지로 아이디를 알려주는 구문
            AlertDialog.Builder fid_id_log = new AlertDialog.Builder(this);
            fid_id_log.setTitle("아이디 안내").setMessage("아이디는 'abcde' 입니다.");

            fid_id_log.setPositiveButton("OK", new DialogInterface.OnClickListener()
            {
                @Override
                public void onClick(DialogInterface dialogInterface, int i)
                {
                    // 사용자가 메세지를 통해 아이디 찾기 안내를 확인하고 로그인창으로 이동하는 구문
                    // 인텐트 사용
                    startActivity(id_intent);
                }
            });

            AlertDialog alertDialog = fid_id_log.create();
            alertDialog.show();
        }
    }
}