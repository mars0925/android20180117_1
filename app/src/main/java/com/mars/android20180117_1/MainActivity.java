package com.mars.android20180117_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


        public int getadd2(int x,int y)
        {
            return x + y ;
        }
    }

