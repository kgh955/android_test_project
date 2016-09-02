package com.example.b.a13_mediaplayer;

import android.media.MediaPlayer;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mp = null;
    SeekBar seekBar;
    private static final int SEEKBAR_CURR_POSITION = 100;
    Handler handler = new Handler(){

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == SEEKBAR_CURR_POSITION){
                int position = msg.arg1;
                seekBar.setProgress(position);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekBar = (SeekBar) findViewById(R.id.seekbar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser == true){
                    if(mp != null){
                        mp.seekTo(progress);
                    }
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

        });
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

                while (mp != null) {
                    try {
                        int position = mp.getCurrentPosition(); // unit msec
                        Log.d("seekbar", "position : " + position);

                        Message msg = handler.obtainMessage();
                        msg.what = SEEKBAR_CURR_POSITION;
                        msg.arg1 = position;
                        handler.sendMessage(msg);

                        try {
                            Thread.sleep(100);// for setting call period : 100 ms
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } catch (Exception e){
                        e.printStackTrace();
                    }

                }
            }
        });
        th.start();
     }

    public void onStopClick(View v) {

        if(mp != null) {
            mp.stop();
            mp.release();// actually this command takes time a little bit to change to end state.
            mp = null;
        }
    }




}
