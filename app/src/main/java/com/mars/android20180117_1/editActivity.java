package com.mars.android20180117_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.mars.android20180117_1.data.student;

public class editActivity extends AppCompatActivity {
    TextView tv12;
    EditText ed4,ed5;
    int id;
    student s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        tv12 = (TextView)findViewById(R.id.textView12);
        ed4 = (EditText)findViewById(R.id.editText4);
        ed5 = (EditText)findViewById(R.id.editText5);
        Intent it = getIntent();
        id =it.getIntExtra("id",id);

        s = MainActivity.dao.getstudent(id);
        tv12.setText(String.valueOf(s.id));
        ed4.setText(s.name);
        ed5.setText(String.valueOf(s.score));
    }

    public void clickOK(View v)
    {

        String name = ed4.getText().toString();
        int score = Integer.valueOf(ed5.getText().toString());

        student s = new student(id,name,score);
        MainActivity.dao.updatestudent(s);
        finish();


        //卡住
        //MainActivity.dao.updatestudent(id,name,)
    }

    public void clickcancel(View v)
    {
        finish();
    }
}
