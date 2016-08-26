package com.example.b.a04_listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String[] myData = {"hello", "world", "oracle", "java",
            "hello1", "world1", "oracle1", "java1",
            "hello2", "world2", "oracle2", "java2",
            "hello3", "world3", "oracle3", "java3",
            "hello4", "world4", "oracle4", "java4",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView)findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                myData);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str = myData[position];
                Toast.makeText(MainActivity.this, "str : "+str, Toast.LENGTH_SHORT).show();
            }
        });


    }
}
