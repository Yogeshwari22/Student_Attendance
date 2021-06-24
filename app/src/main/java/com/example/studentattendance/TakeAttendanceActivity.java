package com.example.studentattendance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.studentattendance.adaptor.StudentAttendanceAdaptor;
import com.example.studentattendance.pojo.Student;
import com.example.studentattendance.tablehelper.AttendanceTableHelper;
import com.example.studentattendance.tablehelper.StudentTableHelper;

import java.util.Calendar;
import java.util.List;

public class TakeAttendanceActivity extends AppCompatActivity {
    TextView selectDate;
    RecyclerView recyclerView;
    Button btnSubmit;
    int day1 , month1, yr1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_attendance);

        selectDate = findViewById(R.id.tVSelectDate);
        recyclerView = findViewById(R.id.recyclerView);
        btnSubmit = findViewById(R.id.btnSubmitAttendance);

        selectDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
               int  day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
               int  yr = calendar.get(Calendar.YEAR);
                DatePickerDialog datePickerDialog = new DatePickerDialog(TakeAttendanceActivity.this, new
                        DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int
                                    dayOfMonth){
                                day1 = dayOfMonth ;
                                month1 = month +1 ;
                                yr1 = year;

                                selectDate.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                                getAllStudents();
                            }
                        },yr,month,day);
                datePickerDialog.show();




            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitAttendance();
            }
        });

    }

    public void getAllStudents(){

        StudentTableHelper sth = new StudentTableHelper();

        List<Student> studentList = sth.getAllStudent(this);

        for(int i=0; i<studentList.size(); i++){

            System.out.println(studentList.get(i).getName());

        }
        String date = day1 +"/" + month1 + "/" + yr1 ;
        System.out.println(date);
        StudentAttendanceAdaptor adapter = new StudentAttendanceAdaptor(studentList,date );
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);
    }


    public void submitAttendance(){
        AttendanceTableHelper ath = new AttendanceTableHelper();
        boolean success =  ath.takeAttendance(this,StudentAttendanceAdaptor.attendanceList);

        if (success){
            Toast.makeText(this, "Attendance Taken successfully", Toast.LENGTH_LONG).show();
            this.finish();
        }
        else
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG).show();
    }
}