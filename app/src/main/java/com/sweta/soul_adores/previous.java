package com.sweta.soul_adores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class previous extends AppCompatActivity {
    TextView msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previous);
        msg=findViewById(R.id.msg);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode==1000 && resultCode==111&& data!=null)
        {
            Bundle b=data.getExtras();
            msg.setText(b.getString("msg"));
        }
    }

    public void next(View v)
    {
        Toast.makeText(this,"BUTTON CLICKED",Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(this,next.class);
        startActivityForResult(intent,1000);
    }
}