package com.sweta.soul_adores.adapter;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.sweta.soul_adores.R;
import com.sweta.soul_adores.model.StudentContact;

public class StudentAdapter extends CursorAdapter {

    @Override
    public Object getItem(int position) {
        return super.getItem(position);
    }

    public StudentAdapter(Context context, Cursor c, int flags) {
        super(context, c,flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.custom_student_record_layout,parent,false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView id,name,add,branch,age;
        id=view.findViewById(R.id.id);
        name=view.findViewById(R.id.name);
        add=view.findViewById(R.id.address);
        branch=view.findViewById(R.id.branch);
        age=view.findViewById(R.id.age);

        id.setText("ID: "+String.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow(StudentContact.ID))));
        age.setText("Age: "+String.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow(StudentContact.AGE))));
        branch.setText("Branch: "+String.valueOf(cursor.getString(cursor.getColumnIndexOrThrow(StudentContact.BRANCH))));
        name.setText("Name: "+String.valueOf(cursor.getString(cursor.getColumnIndexOrThrow(StudentContact.NAME))));
        add.setText("Add.: "+String.valueOf(cursor.getString(cursor.getColumnIndexOrThrow(StudentContact.ADDRESS))));
    }
}
