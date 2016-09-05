package com.example.b.p02_mediaplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.io.IOException;

/**
 * Created by b on 2016-09-05.
 */
public class PlayerActivity extends AppCompatActivity{

    MediaPlayer mp= null;
    String path = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        path = getIntent().getStringExtra("path");
    }

    public void OnPlayClick(View v){
        stopMP();
        mp = new MediaPlayer();
        try {
            mp.setDataSource(path);
            mp.prepare();
            mp.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onStopClick(View v) {
        stopMP();

    }

    private void stopMP(){

        if (mp != null) {
            mp.stop();
            mp.release();
            mp = null;
        }
    }
}
