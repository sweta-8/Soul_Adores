package com.sweta.soul_adores;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class next extends AppCompatActivity   {
    EditText msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        msg=findViewById(R.id.msg);

    }

    public void previous(View v)
    {
        Toast.makeText(this,"BUTTON CLICKED",Toast.LENGTH_SHORT).show();
        final Intent intent = new Intent();
        String m = msg.getText().toString();
        intent.putExtra("msg",m);
        AlertDialog.Builder ad=new AlertDialog.Builder(this);
        ad.setTitle("Select your Choice");
        ad.setMessage("Click any one");
        ad.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                setResult(1111,intent);
                finish();

            }
        });
        ad.setNegativeButton("No",new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(next.this,"CANCEL",Toast.LENGTH_SHORT).show();


            }
        });
        ad.show();

    }
}