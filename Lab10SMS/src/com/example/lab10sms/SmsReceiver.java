package com.example.lab10sms;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class SmsReceiver extends BroadcastReceiver
{
    @Override
    public void onReceive(Context context, Intent intent) 
    {
        //---get the SMS message passed in---
        Bundle bundle = intent.getExtras();        
        SmsMessage[] msgs = null;
        String messageReceived = "";            
        if (bundle != null)
        {
            //---retrieve the SMS message received---
           Object[] pdus = (Object[]) bundle.get("pdus");
            msgs = new SmsMessage[pdus.length];            
            for (int i=0; i<msgs.length; i++)

            {
                msgs[i] = SmsMessage.createFromPdu((byte[])pdus[i]);                
                messageReceived += msgs[i].getMessageBody().toString();
                messageReceived += "\n";        
            }
        }
        Notify(context, "You have new message!", messageReceived);
        
    }    
    private void Notify(Context c,String notificationTitle, String notificationMessage){
        NotificationManager notificationManager = (NotificationManager) c.getSystemService(c.NOTIFICATION_SERVICE);
        @SuppressWarnings("deprecation")
        
        Notification notification = new Notification(R.drawable.ic_launcher,"New Message", System.currentTimeMillis());
        Intent notificationIntent = new Intent(c,MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(c, 0,notificationIntent, 0);
        
        notification.setLatestEventInfo(c, notificationTitle,notificationMessage, pendingIntent);
        notificationManager.notify(9999, notification);
     }
}