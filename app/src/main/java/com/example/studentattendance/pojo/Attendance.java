package com.example.studentattendance.pojo;

import android.content.ContentValues;

import com.example.studentattendance.tablehelper.AttendanceTableHelper;
import com.example.studentattendance.tablehelper.StudentTableHelper;

public class Attendance {
    private String name;
    private int rollNo;
    private String std;
    private String division;
    private  String date;
    private  int present = 0;

    public ContentValues toMap(){
        ContentValues cv = new ContentValues();
        cv.put(AttendanceTableHelper.columnRollNo, rollNo);
        cv.put(AttendanceTableHelper.columnName, name);
        cv.put(AttendanceTableHelper.columnStd, std);
        cv.put(AttendanceTableHelper.columnDivision, division);
        cv.put(AttendanceTableHelper.columnDate, date);
        cv.put(AttendanceTableHelper.columnPresent, present);
        return  cv;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getStd() {
        return std;
    }

    public void setStd(String std) {
        this.std = std;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPresent() {
        return present;
    }

    public void setPresent(int present) {
        this.present = present;
    }

    public Attendance(String name, int rollNo, String std, String division, String date, int present) {
        this.name = name;
        this.rollNo = rollNo;
        this.std = std;
        this.division = division;
        this.date = date;
        this.present = present;
    }

    public Attendance() {
    }
}
