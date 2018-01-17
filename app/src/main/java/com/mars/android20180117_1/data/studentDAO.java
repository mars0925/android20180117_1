package com.mars.android20180117_1.data;

import java.util.ArrayList;

/**
 * Created by Student on 2018/1/17.
 */

public class studentDAO {
    public ArrayList<student> mylist;
    //建構式
    public studentDAO()
    {
        mylist = new ArrayList<>();
    }
    //新增學生
    public boolean add(student s)
    {
        mylist.add(s);
        return true;

    }
    //查詢全部學生
    public ArrayList<student> getList()
    {
        return mylist;
    }

    //查詢學生的方法
    public student getstudent(int id)
    {
        for (student s :mylist)
        {
            if (s.id ==id)
            {
                return s;
            }
        }
        return null;
    }
}
