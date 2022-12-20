package com.sweta.soul_adores;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.sweta.soul_adores.adapter.FBStudentAdapter;
import com.sweta.soul_adores.model.Student;

public class ShowStudentData extends AppCompatActivity {
    RecyclerView rcv;
    FBStudentAdapter fba;
    FirebaseDatabase fd;
    DatabaseReference dbr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_student_data);
        rcv=findViewById(R.id.rcv);
        rcv.setLayoutManager(new LinearLayoutManager(this));
        fd=FirebaseDatabase.getInstance();
        dbr=fd.getReference("Student");
    }

    @Override
    protected void onResume() {
        super.onResume();
        FirebaseRecyclerAdapter<Student,FBStudentAdapter> frc= new FirebaseRecyclerAdapter<Student, FBStudentAdapter>
                (Student.class, R.layout.student_custom_record, FBStudentAdapter.class, dbr) {
            @Override
            protected void populateViewHolder(FBStudentAdapter fbStudentAdapter, Student student, int i) {
                fbStudentAdapter.setView(ShowStudentData.this,
                        student.getid(),student.getSname(),student.getBranch(),student.getAge(),student.getImageurl());
            }
        };
        rcv.setAdapter(frc);

    }
}