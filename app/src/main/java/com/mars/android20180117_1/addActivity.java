package com.mars.android20180117_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.mars.android20180117_1.data.student;

public class addActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
    }
    public void clickadd(View v)
    {
        EditText ed1 = (EditText) findViewById(R.id.editText);
        EditText ed2 = (EditText) findViewById(R.id.editText2);
        EditText ed3 = (EditText) findViewById(R.id.editText3);
        int id = Integer.valueOf(ed1.getText().toString());
        String name = ed2.getText().toString();
        int score = Integer.valueOf(ed3.getText().toString());
        //引用dao的方法
        MainActivity.dao.add(new student(id,name,score));
        finish();
    }
}
