package com.example.b.a09_xml;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
//        MyDomParser parser = new MyDomParser();
        MyPullParser parser = new MyPullParser(textView);
        parser.execute("http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=4143053000");

    }
}
