package com.example.studentattendance.adaptor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studentattendance.R;
import com.example.studentattendance.pojo.Attendance;
import com.example.studentattendance.pojo.Student;

import java.util.ArrayList;
import java.util.List;

public class AttendanceSheetAdapter extends RecyclerView.Adapter<AttendanceSheetAdapter.ViewHolder> {
    public List<Student> studentListForDisplay = new ArrayList<>();
    public static List<Attendance> attendanceListForDisplay = new ArrayList<>();
    public String date;

    public AttendanceSheetAdapter(List<Student> studentListForDisplay, String date) {
        this.studentListForDisplay = studentListForDisplay;
        this.date = date;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.display_student_data_cardview, parent, false);
       ViewHolder holder = new ViewHolder(v);
        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.tVRollNoDisplay.setText(String.valueOf(studentListForDisplay.get(position).getRollNo()));
        holder.tVNameDisplay.setText(studentListForDisplay.get(position).getName());
        Student s = studentListForDisplay.get(position);

    }


    @Override
    public int getItemCount() {
        return studentListForDisplay.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tVRollNoDisplay, tVNameDisplay, tVPOrAb;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tVNameDisplay = itemView.findViewById(R.id.tVStudentNameForDisplay);
            tVPOrAb = itemView.findViewById(R.id.tVPresentOrAbsent);
            tVRollNoDisplay = itemView.findViewById(R.id.tVRollNoForDisplay);
        }
    }
}
