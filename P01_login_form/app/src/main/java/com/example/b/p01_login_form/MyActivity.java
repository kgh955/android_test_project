package com.example.b.p01_login_form;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by b on 2016-08-30.
 */
public class MyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        String strId = getIntent().getStringExtra("id");
        TextView textView = (TextView)findViewById(R.id.secondText);
        textView.setText("Hello "+strId);
    }
}
