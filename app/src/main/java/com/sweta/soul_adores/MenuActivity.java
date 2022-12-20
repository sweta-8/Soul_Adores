package com.sweta.soul_adores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MenuActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
     String activity[]={"StudentRegistration","Quiz","TicTacToe","calculator","MusicService","SongList","WebViewDemo","ContactDetails","SliderImage","colorpicker","MapsActivity","ShowStudentData","AccSensorDemo","BoundedServiceDemo","WifiDemo","NotificationDemo","ContextDemo","counter_activity", "my_activity","AutoComplete"
             ,"SpinnerDemo","OptionDemo","previous","Registration","show_record","FileTest","BarCodeScanner","SpeakActivity","SensorList","ProxySensor","LightSensor"};
     ListView lv;
     ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        lv=findViewById(R.id.menu);
        adapter = new ArrayAdapter<String>(this , R.layout.custom_list_view_design, R.id.text ,activity);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        try
        {
            String s= "com.sweta.soul_adores."+activity[position];
            Class c=Class.forName(s);
            Intent intent = new Intent(MenuActivity.this,c);
            startActivity(intent);
        }
        catch (Exception e)
        {

        }

    }
}