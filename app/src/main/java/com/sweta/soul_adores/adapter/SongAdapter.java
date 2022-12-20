package com.sweta.soul_adores.adapter;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cursoradapter.widget.CursorAdapter;

import com.sweta.soul_adores.R;
import com.sweta.soul_adores.model.StudentContact;

public class SongAdapter extends CursorAdapter {
    public SongAdapter(Context context, Cursor c,int flags) {
        super(context, c,flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.custom_song_list_layout,parent,false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView song ,singer, album;
        ImageView iv;
        MediaMetadataRetriever mmr;
        iv=view.findViewById(R.id.songimage);
        song=view.findViewById(R.id.song);
        singer=view.findViewById(R.id.singer);
        album=view.findViewById(R.id.album);
        mmr = new MediaMetadataRetriever();
       // mmr.setDataSource(cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA)));
        //byte [] b=mmr.getEmbeddedPicture();
       /* if(b!=null)
        {
            Bitmap bmp= BitmapFactory.decodeByteArray(b,0,b.length);
            iv.setImageBitmap(bmp);
        }*/

        song.setText(cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.TITLE)));
        singer.setText(cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.COMPOSER)));
        album.setText(cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ALBUM)));
    }
}
