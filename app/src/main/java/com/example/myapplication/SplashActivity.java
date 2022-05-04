package com.example.myapplication;
/*스플래시화면*/

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        moveMain(1);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

    }

    private void moveMain(int sec) {
        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent); // 메인액티비티 실행
            finish(); // 현재 액티비티 종료
            }
        }, 1000 * sec);
    }
}