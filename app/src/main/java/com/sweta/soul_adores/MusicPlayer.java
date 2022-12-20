package com.sweta.soul_adores;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MusicPlayer extends AppCompatActivity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {
    TextView cdur,rdur,songname;
    SeekBar progress;
    ImageButton play;
    ImageView iv;
    Bundle bundle;
    MediaMetadataRetriever mmr;
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);
        cdur=findViewById(R.id.cdur);
        rdur=findViewById(R.id.rdur);
        songname=findViewById(R.id.songname);
        progress=findViewById(R.id.progress);
        play=findViewById(R.id.play);
        iv=findViewById(R.id.songpic);
        bundle=getIntent().getExtras();
        String s=bundle.getString("song");
        songname.setText(s);
        mmr=new MediaMetadataRetriever();
        mmr.setDataSource(bundle.getString("data"));
        byte[] b=mmr.getEmbeddedPicture();
        if(b!=null)
        {
            Bitmap bmp= BitmapFactory.decodeByteArray(b,0,b.length);
            iv.setImageBitmap(bmp);
        }
        mp=MediaPlayer.create(this, Uri.parse(bundle.getString("data")));
        rdur.setText(convertToDuration(mp.getDuration()));
        progress.setOnSeekBarChangeListener(this);
        play.setOnClickListener(this);
        progress.setMax(mp.getDuration());
        new Thread()
        {
            @Override
            public void run() {
                while(mp.getCurrentPosition()!=mp.getDuration())
                {
                    progress.setProgress(mp.getCurrentPosition());
                }
            }
        }.start();
    }
    public String convertToDuration(long dur)
    {
        String d="";
        dur=dur/1000;
        d=dur/60+":"+dur%60;
        return d;
    }

    @Override
    public void onClick(View view) {
        if(!mp.isPlaying())
        {
            mp.start();
            play.setImageResource(android.R.drawable.ic_media_pause);
        }
        else
        {
            mp.pause();
            play.setImageResource(android.R.drawable.ic_media_play);
        }

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if(fromUser)
        {
            mp.seekTo(progress);
        }
           rdur.setText(convertToDuration(mp.getDuration()-mp.getCurrentPosition()));
           cdur.setText(convertToDuration(mp.getCurrentPosition()));

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {


    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}