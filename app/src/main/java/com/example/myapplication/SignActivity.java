package com.example.myapplication;
/*회원가입화면*/

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class SignActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnId, btnSign;
    TextView textView;
    EditText edName,edId,edPw,edNick,edBirth,edTel,edEmail;
    String compare = "abcd";
    String editText [] = new String[7];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        btnId = (Button) findViewById(R.id.comfirm_id);
        btnSign = (Button) findViewById(R.id.siBtn);

        btnId.setOnClickListener(this); btnSign.setOnClickListener(this);

        textView =(TextView) findViewById(R.id.textView1);



        edName = (EditText) findViewById(R.id.editName);edId = (EditText) findViewById(R.id.editId);
        edPw = (EditText) findViewById(R.id.editPw);edNick = (EditText) findViewById(R.id.editNic);
        edBirth = (EditText) findViewById(R.id.editYear); edTel = (EditText) findViewById(R.id.editTel);
        edEmail = (EditText) findViewById(R.id.editEmail);
        edId.setOnClickListener(this);

    }

    @Override
    public void onClick(View view)
    {
        int a=2;
        // ~.getText().toString() ==> editText 에 있는 내용을 문자열로 가져오는 구문
        // .toString()을 추가안할시에  editText의 데이터를 spannablestringbuilder 형으로 가져옴
        // 회원가입 시에 사용자가 입력한 editText들의 내용을 문자열로 가져와서 데이터를 저장
        
        editText[0] = edName.getText().toString();editText[1] = edId.getText().toString();
        editText[2] = edPw.getText().toString();editText[3] = edNick.getText().toString();
        editText[4] = edBirth.getText().toString();editText[5] = edTel.getText().toString();
        editText[6] = edEmail.getText().toString();

        for(int i=0; i<editText.length; i++)
        {
            if(editText[i].equals(""))
            {
                a = 0;
                break;
            }
            else a = 1;
        }

        if(view.getId() == R.id.comfirm_id)
        {
            if(compare.equals(editText[1]))
            {
                textView.setText("중복된 아이디 입니다.");
                edId.setText(" ");
            }
            else if(editText[1].equals("")) textView.setText("아이디를 입력하세요!");
            else textView.setText("사용가능한 아이디 입니다.");

        }
        if(view.getId() == R.id.siBtn)
        {
            if (a==0)
            {
                AlertDialog.Builder msglog = new AlertDialog.Builder(this);
                msglog.setTitle("회원가입 오류").setMessage("회원정보를 모두 입력해주세요!");

                msglog.setPositiveButton("OK", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    { return;}
                });
                AlertDialog alertDialog = msglog.create();
                alertDialog.show();
            }
            else if(a==1)
            {
                Intent intent_sign = new Intent(SignActivity.this, MainActivity.class);
                startActivity(intent_sign);
            }
        }
    }
}