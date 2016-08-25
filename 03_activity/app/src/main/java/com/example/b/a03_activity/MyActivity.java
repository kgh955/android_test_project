package com.example.b.a03_activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by b on 2016-08-25.
 */
public class MyActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        Intent intent = getIntent();
        //intent.getExtras().get("id").toString();
        String str = intent.getStringExtra("id");
        Toast.makeText(MyActivity.this, "id : ", Toast.LENGTH_SHORT).show();

    }
}
