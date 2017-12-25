package com.example.android.videoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        VideoView video = findViewById(R.id.videoView);
        MediaController mc = new MediaController(this);
        video.setVideoPath("https://d1235ca2z646oc.cloudfront.net/videos/processed/1716/Northernlights2_HD.mp4.mp4");
        mc.setAnchorView(video);
        video.setMediaController(mc);
        video.requestFocus();
        video.start();
    }
}
