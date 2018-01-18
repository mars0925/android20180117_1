package com.mars.android20180117_1;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.mars.android20180117_1.data.student;

public class showActivity extends AppCompatActivity {
    student s;
     TextView tv7,tv8,tv9;
     int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        //接收到intent
        Intent it = getIntent();
        //取出it裡面的資料
        id = it.getIntExtra("id",0);

        tv7 = (TextView)findViewById(R.id.textView7);
        tv8 = (TextView)findViewById(R.id.textView8);
        tv9 = (TextView)findViewById(R.id.textView9);

    }
    //放在onResume裡面的程式,從別一個activity回來之後,資料才會更新
    //activity的生命週期
    @Override
    protected void onResume() {
        super.onResume();
        s = MainActivity.dao.getstudent(id);
        tv7.setText(String.valueOf(s.id));
        tv8.setText(s.name);
        tv9.setText(String.valueOf(s.score));
    }

    public void clickback(View v)
    {
        finish();
    }

    public void clickdelete(View v)
    {
        //彈出對話框確認
        AlertDialog.Builder builder = new AlertDialog.Builder(showActivity.this);
        builder.setTitle("刪除資料");
        builder.setMessage("確定要刪除此筆資料嗎?");
        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.dao.deletestudent(id);
                finish();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.show();
    }

    public void clickedit(View v)
    {
        Intent it = new Intent(showActivity.this,editActivity.class);
        it.putExtra("id",id);
        startActivity(it);
    }


}
