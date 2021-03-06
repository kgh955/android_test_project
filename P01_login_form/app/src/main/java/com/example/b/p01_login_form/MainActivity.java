package com.example.b.p01_login_form;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editId = (EditText) findViewById(R.id.myEdit1);
        SharedPreferences pref = getSharedPreferences("settings", 0);
        String strId = pref.getString("id", "");
        if(strId.equals("") == false) {
            Intent intent = new Intent(MainActivity.this, MyActivity.class);
            intent.putExtra("id", strId);
            startActivity(intent);
        }
    }

    public void onloginClick(View v){
        String strId = editId.getText().toString();
        SharedPreferences pref = getSharedPreferences("settings", 0);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("id", strId);
        editor.commit();

        Intent intent = new Intent(MainActivity.this, MyActivity.class);
        intent.putExtra("id", strId);
        startActivity(intent);
    }

}
