package com.example.kihwani.a21_dialogue;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final int MY_DIALOG = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    // Men
    protected Dialog onCreateDialog(int id) {

        if(id == MY_DIALOG){
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("TITLE");
            builder.setMessage("MESSAGE");
            builder.setIcon(R.mipmap.ic_launcher);
            builder.setCancelable(false);

            // new O typing 하면 DialogInterface.OnClickListener() 가 나타남.
            // positiveButton -> 우측에 가까운 위치에 나타남.
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            // NegativeButton -> Positive 보다 좌측에 나타남.
            builder.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            builder.setView(R.layout.dialog_layout);
            return builder.create();
        }
        return null;
    }

    public void onBtnClick(View v) {

 //       showDialog(MY_DIALOG);
        MyPopup myPopup = new MyPopup(MainActivity.this);
        myPopup.show();
    }
}
