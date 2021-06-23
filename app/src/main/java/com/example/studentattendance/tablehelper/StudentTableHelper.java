package com.example.studentattendance.tablehelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.studentattendance.DatabaseHelper;
import com.example.studentattendance.pojo.Student;

public class StudentTableHelper {

    public static String tableStudent = "student";
    public static  String columnRollNo = "rollNo";
    public static  String columnName = "name";
    public static  String columnStd = "std";
    public static  String columnDivision = "division";
    public static  String createTable = "CREATE TABLE " + tableStudent + "(" +
            columnRollNo + " INTEGER PRIMARY KEY ," + columnName + " VARCHAR(50), "+columnStd+" VARCHAR(10), "+columnDivision+" VARCHAR(10) )";



    public boolean addStudent( Context context, Student s){
        SQLiteDatabase db = DatabaseHelper.getInstance(context).getMyWritableDatabase();
        long suc = db.insert(tableStudent, null, s.toMap());
        return  suc > 0;
    }
}
