package com.example.studentattendance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

public class DatePickerActivity extends AppCompatActivity {
    DatePicker datePicker;
    Button btnSelectDatePicker;
    int day, month , year;
    String date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker);

        datePicker = findViewById(R.id.datePicker);
        btnSelectDatePicker = findViewById(R.id.btnSelectDatePicker);

        btnSelectDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                day = datePicker.getDayOfMonth();
                month = datePicker.getMonth() + 1;
                year = datePicker.getYear();
                date = day + "/" + month + "/" + year;
                System.out.println("Date in date picker " + date);
                Toast.makeText(DatePickerActivity.this,date,Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(DatePickerActivity.this, AttendanceSheetActivity.class);
                intent.putExtra("date",date);
                startActivity(intent);
            }
        });





    }
}