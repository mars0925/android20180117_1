package com.mars.android20180117_1.data;

import android.content.Context;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mars.android20180117_1.MainActivity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Student on 2018/1/18.
 */
//使用firebase儲存
public class studentCloudDAO implements studentDAO {
    public ArrayList<student> mylist;
    Context context;
    FirebaseDatabase database;
    DatabaseReference myRef;
    public studentCloudDAO( final Context context)
    {
        this.context = context;

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("scores");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Gson gson = new Gson();
                mylist = gson.fromJson(value, new TypeToken<ArrayList<student>>(){}.getType());
                ((MainActivity) context).refreshData();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value

            }
        });
        if (mylist == null)
        {
            mylist = new ArrayList<>();
        }
    }
    public boolean add(student s)
    {
        if (mylist == null)
        {
            mylist = new ArrayList<>();
        }
        mylist.add(s);
        saveFile();
        return true;
    }
    private void saveFile()
    {
        // Write a message to the database
        Gson gson = new Gson();
        String data = gson.toJson(mylist);


        myRef.setValue(data);
    }

    public ArrayList<student> getList()
    {
        return mylist;
    }






    public student getstudent(int id)
    {
        for (student s : mylist)
        {
            if (s.id == id)
            {
                return s;
            }
        }
        return null;
    }
    public boolean updatestudent(student s)
    {
        for (student t : mylist)
        {
            if (t.id == s.id)
            {
                t.name = s.name;
                t.score = s.score;
                saveFile();
                return true;
            }
        }
        return false;
    }
    public boolean deletestudent(int id)
    {
        for (int i=0;i<mylist.size();i++)
        {
            if (mylist.get(i).id == id)
            {
                mylist.remove(i);
                saveFile();
                return true;
            }
        }
        return false;
    }
}