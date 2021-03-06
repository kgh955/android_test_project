package com.example.b.a07_asynctask;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
/*
    class  MyAsyncTask extends AsyncTask<Integer, Integer, String>{

        @Override // alt + insert
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            textView.setText("count : "+values[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
             textView.setText(s);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // initialize and so on...before execute
        }

        @Override
        protected String doInBackground(Integer... params) {

            int start = params[0];
            for(int i = start; i<100; i++){
                try {
                    Thread.sleep(100);
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.d("Asynctask", "count : "+i);
            // textView.setText("count : "+i);
                publishProgress(i);

            }

            return "Async done!!!";
        }
    }
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById (R.id.textView);

        MyAsyncTask task = new MyAsyncTask(textView);
        task.execute(10);

    }

}
