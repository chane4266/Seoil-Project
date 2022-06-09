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

public class StoreActivity extends AppCompatActivity implements View.OnClickListener
{
    EditText stName,stYear,stNum,stNick,stAddr,stTel,stEmail;
    String stText [] = new String[7];
    Button stBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        stName = (EditText) findViewById(R.id.editSt_Name);stYear = (EditText) findViewById(R.id.editSt_Year);
        stNum = (EditText) findViewById(R.id.editSt_Num);stNick = (EditText) findViewById(R.id.editSt_Nick);
        stAddr = (EditText) findViewById(R.id.editSt_Addr); stTel = (EditText) findViewById(R.id.editSt_Tel);
        stEmail = (EditText) findViewById(R.id.editSt_Email);

        stBtn = (Button) findViewById(R.id.store_Btn);
        stBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view)
    {
        int x=2;

        stText[0] = stName.getText().toString();stText[1] = stYear.getText().toString();
        stText[2] = stNum.getText().toString();stText[3] = stNick.getText().toString();
        stText[4] = stAddr.getText().toString();stText[5] = stTel.getText().toString();
        stText[6] = stEmail.getText().toString();

        for(int i=0; i<stText.length; i++)
        {
            if(stText[i].equals(""))
            {
                x = 0;
                break;
            }
            else x = 1;
        }

        if(view.getId() == R.id.store_Btn)
        {
            if (x==0)
            {
                AlertDialog.Builder storelog = new AlertDialog.Builder(this);
                storelog.setTitle("가게등록 오류").setMessage("가게정보를 모두 입력해주세요!");

                storelog.setPositiveButton("OK", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    { return;}
                });
                AlertDialog alertDialog = storelog.create();
                alertDialog.show();
            }
            else if(x==1)
            {
                Intent store_sign = new Intent(this, MainActivity.class);
                startActivity(store_sign);
            }
        }
    }
}