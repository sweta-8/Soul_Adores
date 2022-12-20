package com.sweta.soul_adores;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ContextDemo extends AppCompatActivity {
    String name[]={"Nisha Jha","Rahul","Divya","Deokant Jha"};
    ListView tv;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context_demo);
        tv=findViewById(R.id.tv);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,name);
        tv.setAdapter(adapter);
        registerForContextMenu(tv);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Select Your Choice?");
        menu.add(0,v.getId(),0,"CALL");
        menu.add(0,v.getId(),0,"SMS");
        menu.add(0,v.getId(),0,"MMS");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info=(AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        Toast.makeText(this,""+item.getTitle().toString()+" TO "+name[info.position],Toast.LENGTH_SHORT).show();
        return false;
    }
}