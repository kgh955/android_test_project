package com.example.b.a13_mediaplayer;

import android.media.MediaPlayer;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mp = null;
    SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekBar = (SeekBar) findViewById(R.id.seekbar);
    }

    public void onPlayClick(View v){

        // if already on playing, stop and clear before new playing
        if(mp != null) {
            mp.stop();
            mp.release();
            mp = null;
        }
        //---

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
        seekBar.setMax(mp.getDuration());

        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int position = mp.getCurrentPosition(); // unit msec

            }
        });

     }

    public void onStopClick(View v) {

        if(mp != null) {
            mp.stop();
            mp.release();
            mp = null;
        }
    }




}
