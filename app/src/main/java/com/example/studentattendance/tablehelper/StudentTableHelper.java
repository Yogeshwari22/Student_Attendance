package com.example.studentattendance.tablehelper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.Editable;

import com.example.studentattendance.DatabaseHelper;
import com.example.studentattendance.pojo.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentTableHelper {

    public static String tableStudent = "student";
    public static  String columnRollNo = "rollNo";
    public static String columnName = "name";
    public static  String columnStd = "std";
    public static  String columnDivision = "division";
    public static  String createTable = "CREATE TABLE " + tableStudent + "(" +
            columnRollNo + " INTEGER PRIMARY KEY ," + columnName + " VARCHAR(50), "+columnStd+" VARCHAR(10), "+columnDivision+" VARCHAR(10) )";



    public boolean addStudent( Context context, Student s){
        SQLiteDatabase db = DatabaseHelper.getInstance(context).getMyWritableDatabase();
        long suc = db.insert(tableStudent, null, s.toMap());
        db.close();
        return  suc > 0;
    }

    public List<Student> getAllStudent(Context context){
        SQLiteDatabase db = DatabaseHelper.getInstance(context).getMyReadableDatabase();
        List<Student> studentsList = new ArrayList<>();
        String query = "SELECT * FROM "+tableStudent;
        Cursor cursor = db.rawQuery(query, null);
        if(cursor.moveToFirst()){
            do{
                int rollNo = cursor.getInt(0);
                String name = cursor.getString(1);
                String std = cursor.getString(2);
                String division = cursor.getString(3);
                Student s = new Student(rollNo, name, std, division);
                studentsList.add(s);
            }while (cursor.moveToNext());
        }
        return  studentsList;
    }

}
