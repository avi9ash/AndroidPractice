package com.example.android.audioapp;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.SeekBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mc;
    AudioManager am;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MediaController con=new MediaController(this);
         mc =  MediaPlayer.create(this,R.raw.ad);
        am=(AudioManager)getSystemService(Context.AUDIO_SERVICE);
        int maxvolume=am.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int curvolume=am.getStreamVolume(AudioManager.STREAM_MUSIC);

        SeekBar sb = (SeekBar) findViewById(R.id.seekBar);
        sb.setMax(maxvolume);
        sb.setProgress(curvolume);
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Log.i("Seekbar value",Integer.toString(i));
                am.setStreamVolume(AudioManager.STREAM_MUSIC,i,0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        final SeekBar seek =(SeekBar)findViewById(R.id.seekBar2);
        seek.setMax(mc.getDuration());
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                seek.setProgress(mc.getCurrentPosition());
            }
        },0,100);
        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                mc.seekTo(i);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                mc.pause();

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mc.start();

            }
        });
    }
    public void playMusic(View view)
    {
        Button b =(Button)findViewById(R.id.button);
        if(mc.isPlaying())
        {
            mc.pause();
            b.setText("Play");
        }
        else
        {
            mc.start();
            b.setText("Pause");
        }

    }

}
