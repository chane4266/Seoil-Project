package com.example.myapplication;
/*회원가입화면*/

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class SignActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnId;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        btnId = (Button) findViewById(R.id.buttonID);
        btnId.setOnClickListener(this);
        textView =(TextView) findViewById(R.id.textView1);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.buttonID){
            textView.setText("중복된 아이디 입니다.");
        }
    }
}