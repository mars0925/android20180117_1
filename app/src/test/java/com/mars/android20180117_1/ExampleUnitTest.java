package com.mars.android20180117_1;

import com.mars.android20180117_1.data.student;
import com.mars.android20180117_1.data.studentDAO;

import org.junit.Test;

import static org.junit.Assert.*;
////用來測試自己所寫的程式是否正常運作的地方
/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }
    @Test
    public void test_add_data() throws Exception
    {
        studentDAO dao = new studentDAO();
        dao.add(new student(1, "Bob", 95));
        dao.add(new student(2, "Mary", 90));
        assertEquals(2, dao.getList().size());
    }

    @Test
    public void test_add_data2() throws Exception {
        studentDAO dao = new studentDAO();
        dao.add(new student(1, "Bob", 95));
        dao.add(new student(2, "Mary", 90));
        assertEquals(90, dao.getList().get(1).score);
    }
    public void test_getStudent() throws Exception {
        studentDAO dao = new studentDAO();
        dao.add(new student(1, "Bob", 95));
        dao.add(new student(2, "Mary", 90));
        assertEquals(90, dao.getstudent(2).score);
    }
    @Test
    public void test_getStudent1() throws Exception {
        studentDAO dao = new studentDAO();
        dao.add(new student(1, "Bob", 95));
        dao.add(new student(2, "Mary", 90));
        assertEquals(null, dao.getstudent(3));
    }

    @Test
    public void test_updatestudent() throws Exception {
        studentDAO dao = new studentDAO();
        dao.add(new student(1, "Bob", 95));
        dao.updatestudent(new student(1, "Bob", 60));
        assertEquals(60, dao.getstudent(1).score);
    }

    @Test
    public void test_deletestudent() throws Exception {
        studentDAO dao = new studentDAO();
        dao.add(new student(1, "Bob", 95));
        dao.add(new student(2, "Mary", 90));
        dao.deletestudent(1);
        assertEquals(1, dao.getList().size());
    }



}

/*
DAO
DAO 主要是讓處理及操作資料庫更為方便，用來封裝資料庫持久層的操作
將資料處理者(DP) ' 資料使用者(UI設計)的程式分開設計,讓設計UI的人單純透過程式取用資料,
DP在設計好資料取用程式的時候,會透過UniTest測試
 */

/*存放資料的物件
public class student {
    public int id;
    public String name;
    public int score;
    student(int id, String name, int score)
    {
        this.id = id;
        this.name = name;
        this.score = score;
    }
 */
/*增加資料的物件
 public ArrayList<student> mylist;
    public studentADD()
    {
        mylist = new ArrayList<>();
    }
    public void add(student s)
    {
        mylist.add(s);
    }
    public ArrayList<student> getList()
    {
        return mylist;
    }
 */
/*執行增加的main程式(UI設計者只使用不必管其他的程式)
 public static void main(String[] args) {
       studentADD dao = new studentADD();
        dao.add(new student(1, "Bob", 95));
        dao.add(new student(2, "Mary", 80));

        for (student s : dao.getList())
        {
            System.out.println(s.id + "," + s.name + "," + s.score);
        }

    }
 */