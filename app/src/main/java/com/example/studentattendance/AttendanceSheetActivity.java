package com.example.studentattendance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.studentattendance.adaptor.AttendanceSheetAdapter;
import com.example.studentattendance.pojo.Attendance;
import com.example.studentattendance.tablehelper.AttendanceTableHelper;

import java.util.ArrayList;
import java.util.List;

public class AttendanceSheetActivity extends AppCompatActivity {

    RecyclerView recyclerViewForDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance_sheet);


        recyclerViewForDisplay= findViewById(R.id.recyclerViewForDisplay);

        getAttendance(getIntent().getStringExtra("date"));



    }

    public void getAttendance(String date){

        List<Attendance>  attendanceListToDisplay;

        AttendanceTableHelper ath1 = new AttendanceTableHelper();
        attendanceListToDisplay = ath1.getAllStudent(this);
        AttendanceSheetAdapter adapter = new AttendanceSheetAdapter(attendanceListToDisplay);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        recyclerViewForDisplay.setLayoutManager(linearLayoutManager);
        recyclerViewForDisplay.setAdapter(adapter);



    }
}