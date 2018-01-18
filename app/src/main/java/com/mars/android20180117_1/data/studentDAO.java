package com.mars.android20180117_1.data;

import java.util.ArrayList;

/**
 * Created by Student on 2018/1/18.
 */
//正常的作法會是將DAO寫成介面,可以規範使用的人要一定要複寫哪些方法
//如果兩個class都實作同一個介面,可以宣告介面,但是new有impliment此介面的class(異質宣告)
public interface studentDAO {
    public boolean add(student s);
    public ArrayList<student> getList();
    public student getstudent(int id);
    public boolean updatestudent(student s);
    public boolean deletestudent(int id);

}
