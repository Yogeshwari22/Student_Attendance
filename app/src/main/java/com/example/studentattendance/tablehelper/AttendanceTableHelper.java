package com.example.studentattendance.tablehelper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.studentattendance.DatabaseHelper;
import com.example.studentattendance.pojo.Attendance;
import com.example.studentattendance.pojo.Student;

import java.util.ArrayList;
import java.util.List;

public class AttendanceTableHelper {
    public static String tableAttendance = "attendance";
    public static String columnId = "id";
    public static  String columnDate = "date";
    public static  String columnRollNo = "rollNo";
    public static  String columnName = "name";
    public static  String columnStd = "std";
    public static  String columnDivision = "division";
    public static  String columnPresent = "present";
    public static  String createTable = "CREATE TABLE " + tableAttendance + "(" + columnId + " INTEGER PRIMARY KEY AUTOINCREMENT, " + columnDate + " TEXT, "+
            columnRollNo + " INTEGER ," + columnName + " VARCHAR(50), "+columnStd+" VARCHAR(10), "+columnDivision+" VARCHAR(10), "
            +columnPresent+" INTEGER DEFAULT 0)";

    public boolean takeAttendance(Context context, List<Attendance> attendanceList){
        SQLiteDatabase db  = DatabaseHelper.getInstance(context).getMyWritableDatabase();
        long suc = 1;
        for(int i=0; i<attendanceList.size(); i++){
            suc = db.insert(tableAttendance, null, attendanceList.get(i).toMap());
            if(suc<0){
                System.out.printf("Attendance Missed");
            }
        }
        db.close();
        return suc>0;
    }

    public List<Attendance> getAllStudent(Context context){
        SQLiteDatabase db = DatabaseHelper.getInstance(context).getMyReadableDatabase();
        List<Attendance> attendanceList = new ArrayList<>();
        String query = "SELECT * FROM "+tableAttendance + " ORDER BY "+columnRollNo;
        Cursor cursor = db.rawQuery(query, null);
        if(cursor.moveToFirst()){
            do{
                String date = cursor.getString(1);
                int rollNo = cursor.getInt(2);
                String name = cursor.getString(3);
                String std = cursor.getString(4);
                String division = cursor.getString(5);
                int present = cursor.getInt(6);
                Attendance a = new Attendance(name, rollNo, std, division,date, present);
                attendanceList.add(a);
            }while (cursor.moveToNext());
        }
        cursor.close();
        return  attendanceList;
    }
}
