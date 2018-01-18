package com.mars.android20180117_1.data;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by Student on 2018/1/18.
 */

//要建立把資料存在手機檔案的DAO
public class studentFileDAO {
    public ArrayList<student> mylist;

    Context context;
    //建構式 有修改 為了要呼叫getfiledir所以要將Context傳入
    public studentFileDAO(Context context)
    {
        this.context = context;
        mylist = new ArrayList<>();
    }
    //存檔的method
    private void saveFile()
    {
        File f = new File(context.getFilesDir(),"mydata.txt");
        FileWriter fw = null;
        try {
            fw = new FileWriter(f);
            Gson gson = new Gson();
            String data = gson.toJson(mylist);
            fw.write(data);
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    private void load()
    {
        File f = new File(context.getFilesDir(),"mydata.txt");
        FileReader fr = null;
        try {
            fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String str = br.readLine();
            Gson gson = new Gson();
            mylist = gson.fromJson(str, new TypeToken<ArrayList<student>>(){}.getType());
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    //新增學生
    public boolean add(student s)
    {
        mylist.add(s);
        saveFile();
        return true;

    }
    //查詢全部學生
    public ArrayList<student> getList()
    {
        load();
        return mylist;
    }

    //查詢學生的方法
    public student getstudent(int id)
    {
        load();
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
        load();
        for(int i = 0;i<=mylist.size();i++)
        {
            if (mylist.get(i).id == s.id)
            {
                mylist.get(i).name = s.name;
                mylist.get(i).score = s.score;
                saveFile();
                return  true;
            }
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
        load();
        for(int i = 0;i<=mylist.size();i++)
        {
            if (mylist.get(i).id == id)
            {
                mylist.remove(i);
                saveFile();
                return  true;
            }

        }
        return  false;
    }
}
