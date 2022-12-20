package com.sweta.soul_adores;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class SensorList extends AppCompatActivity {
    SensorManager sm;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_list);
        tv=findViewById(R.id.sensor);
         sm=(SensorManager) getSystemService(SENSOR_SERVICE);
        List<Sensor> list=sm.getSensorList(Sensor.TYPE_ALL);
        tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        for(Sensor s:list)
        {
              tv.append(s.getName()+"||"+s.getType()+"||"+s.getVendor());
        }
    }
}