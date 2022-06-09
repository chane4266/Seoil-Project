package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FindPWActivity extends AppCompatActivity implements View.OnClickListener
{
    Button findpw, submitcode;
    EditText secode;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_pwactivity);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        findpw = (Button) findViewById(R.id.find_pw_btn);
        findpw.setOnClickListener(this);

        submitcode = (Button) findViewById(R.id.submit_btn);
        submitcode.setOnClickListener(this);

        secode = (EditText) findViewById(R.id.secode_editText);
        secode.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        AlertDialog.Builder find_pw_log = new AlertDialog.Builder(this);
        Intent pw_intent = new Intent(this,LoginActivity.class);
        if(view.getId() == R.id.find_pw_btn)
        {
            if(secode.getText().toString().equals(""))
            {
                // 사용자가 인증코드를 입력안했을시 실행되는 구문
                find_pw_log.setTitle("인증코드 오류").setMessage("인증코드를 입력해주세요!");

                //
                find_pw_log.setPositiveButton("OK", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    { return; }
                });
            }
            else
            {
                // 사용자가 '확인'버튼을 눌렀을때 메세지로 비밀번호를 이메일로 전송했음을 알려주는 구문
                find_pw_log.setTitle("비밀번호 안내").setMessage("입력하신 이메일주소로 전송하였습니다.");

                //
                find_pw_log.setPositiveButton("OK", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {
                        // 사용자가 메세지를 통해 비밀번호 찾기 안내를 확인하고 로그인창으로 이동하는 구문
                        // 인텐트 사용
                        startActivity(pw_intent);
                    }
                });
            }

            AlertDialog alertDialog = find_pw_log.create();
            alertDialog.show();
        }
        if(view.getId() == R.id.submit_btn)
        {
            // 사용자가 '전송'버튼을 눌렀을때 인증코드를 사용자 이메일로 전송했음을 알려주는 코드
            find_pw_log.setTitle("인증코드 안내").setMessage("인증코드를 입력하신 이메일주소로 전송하였습니다.");

            find_pw_log.setPositiveButton("OK", new DialogInterface.OnClickListener()
            {
                @Override
                public void onClick(DialogInterface dialogInterface, int i)
                { return; }
            });

            AlertDialog alertDialog = find_pw_log.create();
            alertDialog.show();
        }
    }
}