package com.example.studentattendance;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.studentattendance.tablehelper.AttendanceTableHelper;
import com.example.studentattendance.tablehelper.StudentTableHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static DatabaseHelper singleToneInstance = null;
    public  static  String DATABASE_NAME = "attendance";

    private DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    public static DatabaseHelper getInstance(Context context){
        if(singleToneInstance == null){
            singleToneInstance = new DatabaseHelper(context.getApplicationContext());
        }
        return  singleToneInstance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(StudentTableHelper.createTable);
        db.execSQL(AttendanceTableHelper.createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public SQLiteDatabase getMyWritableDatabase(){
        return  this.getWritableDatabase();
    }

    public SQLiteDatabase getMyReadableDatabase(){
        return  this.getReadableDatabase();
    }
}
