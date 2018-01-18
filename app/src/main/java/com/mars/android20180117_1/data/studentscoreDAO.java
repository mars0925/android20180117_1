package com.mars.android20180117_1.data;

import java.util.ArrayList;

/**
 * Created by Student on 2018/1/17.
 */

public class studentscoreDAO implements studentDAO{
    public ArrayList<student> mylist;
    //建構式
    public studentscoreDAO()
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

    //修改
    public boolean updatestudent(student s)
    {
        for(int i = 0;i<=mylist.size();i++)
        {
            if (mylist.get(i).id == s.id)
            {
                mylist.get(i).name = s.name;
                mylist.get(i).score = s.score;
            }
            return  true;

        }
        return  false;
    }
    /*
    布林值代表這個程式是否刪除成功的訊號
    如果return  true放到if迴圈之外,他會跑第一次迴圈就傳出成功的訊號
    呼叫的程式以為他跑成功了,但是實際上for迴圈沒有跑完,可能沒有刪除到
    */
    //刪除
    public boolean deletestudent(int id)
    {
        for(int i = 0;i<=mylist.size();i++)
        {
            if (mylist.get(i).id == id)
            {
                mylist.remove(i);
                return  true;
            }

        }
        return  false;
    }
}
