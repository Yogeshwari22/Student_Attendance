package com.example.studentattendance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnTakeAttendance, btnAddStudent, btnAttendanceSheet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAddStudent = findViewById(R.id.btnAddStudent);
        btnAttendanceSheet = findViewById(R.id.btnAttendanceSheet);
        btnTakeAttendance = findViewById(R.id.btnTakeAttendance);


        btnTakeAttendance.setOnClickListener(MainActivity.this);
        btnAttendanceSheet.setOnClickListener(MainActivity.this);
        btnAddStudent.setOnClickListener(MainActivity.this);
    }


   @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnAddStudent :{
                Intent intent =new Intent(MainActivity.this, AddStudentActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btnAttendanceSheet :{
                Intent intent =new Intent(MainActivity.this, AttendanceSheetActivity.class);
                startActivity(intent);
                break;

            }
            case R.id.btnTakeAttendance :{
                Intent intent =new Intent(MainActivity.this, TakeAttendanceActivity.class);
                startActivity(intent);
                break;
            }
        }
   }
}