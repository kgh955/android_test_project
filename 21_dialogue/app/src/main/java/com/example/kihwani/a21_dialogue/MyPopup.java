package com.example.kihwani.a21_dialogue;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by kihwani on 2016-09-08.
 */
public class MyPopup extends Dialog{
    Context context;

    public MyPopup(Context context){
            super(context);
            this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.dialog_layout);
        Button btn = (Button) findViewById(R.id.btnDialog);
//        setCancelable(false);
//        setCanceledOnTouchOutside(false);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MyPopup(context).show();
            }
        });
    }
}
