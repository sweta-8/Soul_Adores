package com.sweta.soul_adores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;


public class OptionDemo extends AppCompatActivity implements View.OnClickListener {
    Button popup;
    PopupMenu popupMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_demo);
        popup=findViewById(R.id.popup);
        popup.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch(item.getTitle().toString())
        {
            case "Gallery":
                Intent gallery =new Intent();
                gallery.setType("image/*");
                gallery.setAction(Intent.ACTION_GET_CONTENT);
                startActivity(gallery);
                break;
            case "Home":
                Intent intent =new Intent(OptionDemo.this,MenuActivity.class);
                startActivity(intent);
                break;
            case "Music":
                Intent m =new Intent();
                m.setType("audio/*");
                m.setAction(Intent.ACTION_GET_CONTENT);
                startActivity(m);
                break;
            case "Call":
                Intent c =new Intent(Intent.ACTION_DIAL);
                startActivity(c);
                break;
            case "SMS":
                Intent s =new Intent(Intent.ACTION_SENDTO);
                s.setData(Uri.parse("smsto:"+Uri.encode("87654321")));
                break;

        }
        return false;
    }

    @Override
    public void onClick(View v) {
        popupMenu=new PopupMenu(this,popup);
        popupMenu.getMenuInflater().inflate(R.menu.mymenu,popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                popup.setText(item.getTitle().toString());
                return false;
            }
        });
        popupMenu.show();

    }
}