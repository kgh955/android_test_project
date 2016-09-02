package com.example.b.a13_mediaplayer;

import android.media.MediaPlayer;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mp = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onPlayClick(View v){

        String path = Environment.getExternalStorageDirectory().toString();
//        path += "/Download/Kalimba.mp3";
        path += "/jdny85.mp3";

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

        if(mp != null) {
            mp.stop();
            mp.release();
            mp = null;
        }
    }

    


}
