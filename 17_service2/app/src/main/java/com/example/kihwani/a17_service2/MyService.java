package com.example.kihwani.a17_service2;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.Random;

public class MyService extends Service {
    public MyService() {
    }

    class Mybinder extends Binder{
        public MyService getService(){
            return MyService.this;
        }
    }

    Mybinder binder = new Mybinder();

    @Override
    public IBinder onBind(Intent intent) {
            return binder;
    }

    Random random = new Random();
    public int getRandomNumber(){
        return random.nextInt(100);
    }
}
