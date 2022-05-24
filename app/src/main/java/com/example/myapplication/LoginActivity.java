package com.example.myapplication;
/*로그인 화면*/

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener
{
    Button btn01, btn02, btn03, btn04;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        btn01 = (Button) findViewById(R.id.signBtn);
        btn01.setOnClickListener(this);

        btn02 = (Button) findViewById(R.id.store_sign_Btn);
        btn02.setOnClickListener(this);

        btn03 = (Button) findViewById(R.id.idPwBtn);
        btn03.setOnClickListener(this);

        btn04 = (Button) findViewById(R.id.idPwBtn2);
        btn04.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.signBtn) {
            Intent intent01 = new Intent(this, SignActivity.class);
            startActivity(intent01);
        }
        if(view.getId() == R.id.store_sign_Btn) {
            Intent intent02 = new Intent(this, StoreActivity.class);
            startActivity(intent02);
        }
        if(view.getId()==R.id.idPwBtn){
            Intent intent03 = new Intent(this,FindIdActivuty.class);
            startActivity(intent03);
        }
        if(view.getId()==R.id.idPwBtn2){
            Intent intent04 = new Intent(this,FindPWActivity.class);
            startActivity(intent04);
        }
    }
}