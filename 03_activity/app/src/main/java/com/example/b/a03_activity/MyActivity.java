package com.example.b.a03_activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by b on 2016-08-25.
 */
public class MyActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        final Intent intent = getIntent();
        //intent.getExtras().get("id").toString();
        String str = intent.getStringExtra("id");
        Toast.makeText(MyActivity.this, "id : ", Toast.LENGTH_SHORT).show();

        Button btnFinish =(Button)findViewById(R.id.btnFinish);
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // return value from Myactivity to main activity.
                Intent resultIntent = new Intent();
                resultIntent.putExtra("myResult", "abcdef");
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}
