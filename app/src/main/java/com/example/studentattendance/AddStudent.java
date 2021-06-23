package com.example.studentattendance;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddStudent extends AppCompatActivity implements View.OnClickListener {
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


    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
       /* switch(v.getId()){
            case R.id.eTName :

        }*/
    }
}