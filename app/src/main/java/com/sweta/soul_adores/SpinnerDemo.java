package com.sweta.soul_adores;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;


public class SpinnerDemo extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinner;
    TextView t1;
    ConstraintLayout cl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_demo);
        t1=findViewById(R.id.t1);
        cl=findViewById(R.id.cl);
        spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int i, long l)
    {
        String selectedClass = parent.getItemAtPosition(i).toString();
        switch(selectedClass)
        {
            case "Default":
                cl.setBackgroundColor(Color.WHITE);
                break;
            case "Red":
                cl.setBackgroundColor(Color.RED);
                break;
            case "Green":
                cl.setBackgroundColor(Color.GREEN);
                break;
            case "Gray":
                cl.setBackgroundColor(Color.GRAY);
                break;
            case "Blue":
                cl.setBackgroundColor(Color.BLUE);
                break;
            case "Yellow":
                cl.setBackgroundColor(Color.YELLOW);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView)
    {

    }
}
