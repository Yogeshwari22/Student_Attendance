package com.example.studentattendance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.studentattendance.adaptor.StudentAttendanceAdaptor;
import com.example.studentattendance.pojo.Student;
import com.example.studentattendance.tablehelper.StudentTableHelper;

import java.util.Calendar;
import java.util.List;

public class TakeAttendanceActivity extends AppCompatActivity {
    TextView selectDate;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_attendance);

        selectDate = findViewById(R.id.tVSelectDate);
        recyclerView = findViewById(R.id.recyclerView);

        selectDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
                int yr = calendar.get(Calendar.YEAR);
                DatePickerDialog datePickerDialog = new DatePickerDialog(TakeAttendanceActivity.this, new
                        DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int
                                    dayOfMonth){

                                selectDate.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                            }
                        },yr,month,day);
                datePickerDialog.show();

                getAllStudents();

            }
        });
    }

    public void getAllStudents(){

        StudentTableHelper sth = new StudentTableHelper();

        List<Student> studentList = sth.getAllStudent(this);

        for(int i=0; i<studentList.size(); i++){

            System.out.println(studentList.get(i).getName());

        }

        StudentAttendanceAdaptor adapter = new StudentAttendanceAdaptor(studentList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);
    }
}