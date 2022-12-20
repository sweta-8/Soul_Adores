package com.sweta.soul_adores;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class calculator extends AppCompatActivity implements View.OnClickListener
{
    TextView result;
    EditText num1,num2;
    Button a,s,d,p,si,co;
     //implementation 'org.jetbrains:annotations-java5:15.0'
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        result=findViewById(R.id.res);
        num1=findViewById(R.id.n1);
        num2=findViewById(R.id.n2);
        a=findViewById(R.id.add);
        s=findViewById(R.id.sub);
        d=findViewById(R.id.div);
        p=findViewById(R.id.mul);
        si=findViewById(R.id.sin);
        co=findViewById(R.id.cos);
        a.setOnClickListener(this);
        s.setOnClickListener(this);
        d.setOnClickListener(this);
        p.setOnClickListener(this);
        si.setOnClickListener(this);
        co.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
     double n1 = Double.parseDouble(num1.getText().toString());
     double n2 = Double.parseDouble(num2.getText().toString());
     double b =  Math.toRadians(n1);
     switch(v.getId())
     {
         case R.id.add:
             result.setText(String.valueOf(n1+n2));
             break;
         case R.id.sub:
             result.setText(String.valueOf(n1-n2));
             break;
         case R.id.mul:
             result.setText(String.valueOf(n1*n2));
             break;
         case R.id.div:
             result.setText(String.valueOf(n1/n2));
             break;
         case R.id.sin:
             result.setText(String.valueOf(Math.sin(b)));
             break;
         case R.id.cos:
             result.setText(String.valueOf(Math.cos(b)));
             break;
     }
    }
}