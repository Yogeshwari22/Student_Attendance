package com.example.studentattendance.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studentattendance.R;
import com.example.studentattendance.pojo.Attendance;
import com.example.studentattendance.pojo.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentAttendanceAdaptor extends RecyclerView.Adapter<StudentAttendanceAdaptor.ViewHolder> {
    public List<Student> studentList = new ArrayList<>();
    public static List<Attendance> attendanceList = new ArrayList<>();
     public String date;

    public StudentAttendanceAdaptor(List<Student> studentList,String date) {
        this.studentList = studentList;
        this.date = date;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_data_cardview, parent, false);
        ViewHolder holder = new ViewHolder(v);
        return holder;

    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       holder.rollNo.setText(String.valueOf(studentList.get(position).getRollNo()));
       holder.studentName.setText(studentList.get(position).getName());
       int present = holder.checkbox.isChecked() ? 1 : 0 ;
       Student s = studentList.get(position);
       Attendance a = new Attendance(s.getName(),s.getRollNo(),s.getStd(),s.getDivision(),StudentAttendanceAdaptor.this.date, present);
       attendanceList.add(a);
       holder.checkbox.setOnCheckedChangeListener(
               new CompoundButton.OnCheckedChangeListener() {
                   @Override
                   public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                       attendanceList.get(position).setPresent(isChecked ? 1 : 0 ) ;
                   }
               }
       );
    }


    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView rollNo, studentName;
        CheckBox checkbox;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rollNo = itemView.findViewById(R.id.tVRollNo);
            studentName = itemView.findViewById(R.id.tVStudentName);
            checkbox = itemView.findViewById(R.id.checkBox);
        }
    }

}
