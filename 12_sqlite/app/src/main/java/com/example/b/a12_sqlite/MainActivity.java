package com.example.b.a12_sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TestDBHandler testDBHandler = new TestDBHandler(this);
        testDBHandler.insert("kim", "seoul", 20);
        testDBHandler.insert("가나다", "인천", 21);
        testDBHandler.insert("john", "la", 22);

        testDBHandler.delete("kim");
        testDBHandler.update("john", 33);

        testDBHandler.showAllData();
    }
}
