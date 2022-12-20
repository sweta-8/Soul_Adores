package com.sweta.soul_adores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.sweta.soul_adores.R;
import com.sweta.soul_adores.adapter.SongAdapter;

import java.util.ArrayList;

public class SongList extends AppCompatActivity implements  AdapterView.OnItemClickListener {
    Cursor c;
    SongAdapter sa;
    ListView songlist;
    ArrayList<String> data =new ArrayList<String>();
    ArrayList<String> song =new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_list);
        songlist=findViewById(R.id.songlist);
        c=getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,null,null,null,null);
        sa=new SongAdapter(this,c,10);
        songlist.setAdapter(sa);
        songlist.setOnItemClickListener(this);
        while(c.moveToNext())
        {
            data.add(c.getString(c.getColumnIndex(MediaStore.Audio.Media.DATA)));
            song.add(c.getString(c.getColumnIndex(MediaStore.Audio.Media.TITLE)));
        }
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

        Intent intent=new Intent(SongList.this,MusicPlayer.class);
        intent.putExtra("song",song.get(position));
        intent.putExtra("data",data.get(position));
        startActivity(intent);
    }
}