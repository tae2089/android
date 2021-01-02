package org.techtown.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

public class SmsReceiver extends BroadcastReceiver {
    private static final String TAG = "SmsReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceiver 호출됨");
        Bundle bundle = intent.getExtras();
        SmsMessage[] message = parseSmsMessage(bundle);
        if (message != null && message.length >0)  {
            String sender = message[0].getOriginatingAddress();
            String content = message[0].getMessageBody();
            Log.d(TAG, "sender :" + sender + ", contents :" + content);
            sendToActivity(context,sender,content);
        }
    }

    private void sendToActivity(Context context, String sender, String content) {
        Intent intent = new Intent(context, SmsActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        intent.putExtra("sender", sender);
        intent.putExtra("contents", content);
        context.startActivity(intent);
    }

    private SmsMessage[] parseSmsMessage(Bundle bundle) {
        Object[] objs =(Object[]) bundle.get("pdus");
        SmsMessage[] messages = new SmsMessage[objs.length];
        int smscount = objs.length;
        for (int i = 0; i < smscount; i++) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                String format = bundle.getString("format");
                messages[i] = SmsMessage.createFromPdu((byte[])objs[i],format);
            }else{
                messages[i] = SmsMessage.createFromPdu((byte[])objs[i]);
            }
        }
        return messages;
    }
}