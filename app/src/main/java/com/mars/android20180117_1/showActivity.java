package com.mars.android20180117_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.mars.android20180117_1.data.student;

public class showActivity extends AppCompatActivity {
    student s;
     TextView tv7,tv8,tv9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        //接收到intent
        Intent it = getIntent();
        //取出it裡面的資料
        int id = it.getIntExtra("id",0);
        s = MainActivity.dao.getstudent(id);
        tv7 = (TextView)findViewById(R.id.textView7);
        tv8 = (TextView)findViewById(R.id.textView8);
        tv9 = (TextView)findViewById(R.id.textView9);
        tv7.setText(String.valueOf(s.id));
        tv8.setText(s.name);
        tv9.setText(String.valueOf(s.score));
    }
}
