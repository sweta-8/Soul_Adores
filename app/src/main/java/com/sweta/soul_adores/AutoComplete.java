package com.sweta.soul_adores;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

public class AutoComplete extends AppCompatActivity {
    AutoCompleteTextView act;
    MultiAutoCompleteTextView mact;
    String name[] ={"Priye","Ankush","Angel","Sweta","Divya"};
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete);
        act=findViewById(R.id.act);
        mact=findViewById(R.id.mact);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,name);
        act.setAdapter(adapter);
        mact.setAdapter(adapter);
        act.setThreshold(1); //show we get suggestion after filling first word
        mact.setThreshold(1);
        mact.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
    }
}