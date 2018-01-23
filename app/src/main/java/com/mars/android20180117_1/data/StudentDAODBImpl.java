package com.mars.android20180117_1.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by Student on 2018/1/22.
 */

public class StudentDAODBImpl implements studentDAO {
    Context context;
    SQLiteDatabase db;
    public StudentDAODBImpl(Context context)
    {
        this.context = context;
        MyDBHelper helper = new MyDBHelper(context);
        db = helper.getWritableDatabase();
    }



    @Override
    public boolean add(student s) {
        ContentValues cv = new ContentValues();
        cv.put("_id", s.id);
        cv.put("name", s.name);
        cv.put("score", s.score);
        db.insert("students", null, cv);
        return true;

    }

    @Override
    public ArrayList<student> getList() {
        ArrayList<student> mylist = new ArrayList<>();
        Cursor c = db.query("students", new String[] {"_id", "name", "score"}, null, null, null, null, null);
        if (c.moveToFirst())
        {
            //把資料庫的資料倒出來 裝到ArrayList裡 再回傳
            student s1 = new student(c.getInt(0), c.getString(1), c.getInt(2));
            mylist.add(s1);
            while(c.moveToNext())
            {
                student s = new student(c.getInt(0), c.getString(1), c.getInt(2));
                mylist.add(s);
            }
        }
        return mylist;
    }

    @Override
    public student getstudent(int id) {
        Cursor c = db.query("students", new String[] {"_id", "name", "score"}, "_id=?", new String[] {String.valueOf(id)}, null, null, null);
        if (c.moveToFirst())
        {
            student s1 = new student(c.getInt(0), c.getString(1), c.getInt(2));
            return s1;
        }
        return null;
    }

    @Override
    public boolean updatestudent(student s) {
        ContentValues cv = new ContentValues();
        cv.put("name", s.name);
        cv.put("score", s.score);
        db.update("students", cv, "_id=?", new String[] {String.valueOf(s.id)});
        return true;
    }

    @Override
    public boolean deletestudent(int id) {

        db.delete("students", "_id=?", new String[] {String.valueOf(id)});
        return true;
    }
}
