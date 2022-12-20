package com.sweta.soul_adores;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.sweta.soul_adores.broadcast.MyBroadCast;

import java.util.Calendar;

public class my_activity extends Activity {
    DatePicker datePicker;
    Button getdate;
    TextView tv;
    private int m,y,d,h,s,min;
    DatePickerDialog dialog;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_activity);
        tv=findViewById(R.id.tv);
        //datepicker=findViewById(R.id.datepicker);
        getdate=findViewById(R.id.changedate);
        //tv.setText("Date : "+getDate());
        getdate.setOnClickListener(new View.OnClickListener() {
            @RequiresApi (api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                Calendar c=Calendar.getInstance();
                y=c.get(Calendar.YEAR);
                m=c.get(Calendar.MONTH);
                d=c.get(Calendar.DAY_OF_MONTH);
                /*dialog=new DatePickerDialog(my_activity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        tv.setText(dayOfMonth+"-"+(month+1)+"-"+year);
                    }
                },y,m,d);
                dialog.show();*/
                TimePickerDialog time=new TimePickerDialog(my_activity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourofday, int minute) {
                        tv.setText(hourofday+":"+minute);
                    }
                },h,min,true);
                time.show();
                //tv.seText("Date : "+getDate());

            }
        });
    }
    /*private String getDate()
    {
        String s="";
        s=s+datePicker.getDayOfMonth()+"/"+(datePicker.getMonth()+1)+"/"+datePicker.getYear();
        return s;
    }*/


    public void genrateBroadCast(View view)
    {
        Intent intent = new Intent(my_activity.this, MyBroadCast.class);
        sendBroadcast(intent);
    }


}
