package com.example.studentattendance.pojo;

import android.content.ContentValues;

import com.example.studentattendance.tablehelper.StudentTableHelper;

public class Student {
    private String name;
    private int rollNo;
    private String std;
    private String division;

    public Student() {
    }

    public Student( int rollNo,String name, String std, String division) {
        this.name = name;
        this.rollNo = rollNo;
        this.std = std;
        this.division = division;
    }

    public ContentValues toMap(){
        ContentValues cv = new ContentValues();
        cv.put(StudentTableHelper.columnRollNo, rollNo);
        cv.put(StudentTableHelper.columnName, name);
        cv.put(StudentTableHelper.columnStd, std);
        cv.put(StudentTableHelper.columnDivision, division);
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
}
