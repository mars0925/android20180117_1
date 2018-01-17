package com.mars.android20180117_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.mars.android20180117_1.data.student;
import com.mars.android20180117_1.data.studentDAO;

import java.util.ArrayList;

//
public class MainActivity extends AppCompatActivity {
    TextView tv4,tv5,tv6;
    ListView listView;
    final public static studentDAO dao = new studentDAO();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.listview1);
    }

    @Override
    //從ADDactivity回來後 程式不會在onCreate ,所以要onResume
    protected void onResume() {
        super.onResume();
        /* 使用arrayadapter來顯示
        ArrayList<String> studentName = new ArrayList<>();
        for(student s : dao.getList())
        {
            studentName.add(s.name);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1,studentName);

        listView.setAdapter(adapter);
        */
        Myadapter adapter = new Myadapter();

        listView.setAdapter(adapter);

        //可以讓item可以被點選,然後作動
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(MainActivity.this,showActivity.class);
                //用putExtra把資料送出到showActivity
                it.putExtra("id",dao.getList().get(i).id);
                startActivity(it);
            }
        });

    }
    //產生menu清單
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_add)
        {
            //點選後到addActivity那一頁
            Intent it = new Intent(MainActivity.this, addActivity.class);
            startActivity(it);
        }
        return super.onOptionsItemSelected(item);
    }
    //自訂baseadapter 給listview用
    class Myadapter extends BaseAdapter{

        @Override
        public int getCount() {
            return dao.getList().size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
            //解出自訂的layout
            View v = inflater.inflate(R.layout.mylayout,null);
            //找到自訂layout上面的textview
            tv4 = v.findViewById(R.id.textView4);
            tv5 = v.findViewById(R.id.textView5);
            tv6 = v.findViewById(R.id.textView6);
            tv4.setText(String.valueOf(dao.getList().get(i).id));
            tv5.setText(String.valueOf(dao.getList().get(i).name));
            tv6.setText(String.valueOf(dao.getList().get(i).score));
            return v;
        }
    }
}

