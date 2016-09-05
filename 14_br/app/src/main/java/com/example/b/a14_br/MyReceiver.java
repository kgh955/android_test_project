package com.example.b.a14_br;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    public MyReceiver() {

    }

    @Override
    // intent : receive type에 따른 data가  intent에 실려서 옴.(ex. battery low..
    public void onReceive(Context context, Intent intent) {
//        // TODO: This method is called when the BroadcastReceiver is receiving
//        // an Intent broadcast.
//        throw new UnsupportedOperationException("Not yet implemented");
            String str = "";
            Object[] pdus = (Object[]) intent.getExtras().get("pdus");
            SmsMessage[] msgs = new SmsMessage[pdus.length];

            for(int i = 0; i< msgs.length; i++){
                msgs[i] = SmsMessage.createFromPdu((byte[])pdus[i]);

                str += "SMS from : "+msgs[i].getOriginatingAddress();
                str += " / "+msgs[i].getMessageBody();
            }
        Toast.makeText(context, str, Toast.LENGTH_LONG).show();
    }

}
