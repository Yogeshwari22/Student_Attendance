package com.example.studentattendance;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.studentattendance.pojo.Student;
import com.example.studentattendance.tablehelper.StudentTableHelper;

public class AddStudentActivity extends AppCompatActivity implements View.OnClickListener {
    EditText eTName, eTClass, eTDiv, eTRollNo;
    Button btnSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        eTClass=findViewById(R.id.eTClass);
        eTDiv=findViewById(R.id.eTDiv);
        eTName=findViewById(R.id.eTName);
        eTRollNo=findViewById(R.id.eTRollNo);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(this);

    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
       switch(v.getId()){
            case R.id.btnSubmit :
                submit();

                 break;

        }
    }

    public void submit(){
        String name, std, div;
        int rollNo = -1;

        name = eTName.getText().toString();
        std = eTClass.getText().toString();
        div = eTDiv.getText().toString();

        if (! eTRollNo.getText().toString().isEmpty()){
            rollNo = Integer.parseInt(eTRollNo.getText().toString());
        }


        if(name.isEmpty() || std.isEmpty() || div.isEmpty() || rollNo < 0 ){
            Toast.makeText(this, "Please fill all fields",Toast.LENGTH_LONG).show();
            return ;

        }

        Student s = new Student(rollNo, name, std, div);
        StudentTableHelper sth1 = new StudentTableHelper();


        boolean success = sth1.addStudent(this,s);

        if (success){
            Toast.makeText(this, "Student added successfully",Toast.LENGTH_SHORT).show();
            this.finish();
        }
        else{
            Toast.makeText(this, "Something Went Wrong",Toast.LENGTH_SHORT).show();

        }

    }
}