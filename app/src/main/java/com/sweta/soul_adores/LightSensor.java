package com.sweta.soul_adores;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import com.sweta.soul_adores.R;

public class LightSensor extends AppCompatActivity {
    SensorManager sm;
    Sensor s;
    TextView tv;
    SensorEventListener sel=new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            float x = event.values[0];
            tv.setText(String.valueOf(x));
        }
        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {

        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_list);
        sm=(SensorManager) getSystemService(SENSOR_SERVICE);
        tv=findViewById(R.id.sensor);
        s=sm.getDefaultSensor(Sensor.TYPE_LIGHT);
        sm.registerListener(sel,s,SensorManager.SENSOR_DELAY_NORMAL);
    }
}