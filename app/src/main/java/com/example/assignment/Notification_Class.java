package com.example.assignment;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import static android.content.ContentValues.TAG;

public class Notification_Class extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        showNotification1(remoteMessage.getNotification().getTitle(),remoteMessage.getNotification().getBody(),remoteMessage.getNotification().getChannelId());
//        showNotification2(remoteMessage.getNotification().getTitle(),remoteMessage.getNotification().getBody(),remoteMessage.getNotification().getChannelId());
    }
    public void showNotification1(String title,String message,String ChannelId)
    {
        if (ChannelId.equals("Message")) {
            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, new Intent(this, Message.class), 0);
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "Channel")
                    .setContentTitle(title)
                    .setSmallIcon(R.drawable.ic_stat_name)
                    .setAutoCancel(true)
                    .setContentIntent(pendingIntent)
                    .setContentText(message);

            NotificationManagerCompat manager = NotificationManagerCompat.from(this);
            manager.notify(0, builder.build());
        }
        else if (ChannelId.equals("Notification")){
            PendingIntent pendingIntent = PendingIntent.getActivity(this,1,new Intent(this,Notifications.class),1);
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this,"Channel")
                    .setContentTitle(title)
                    .setSmallIcon(R.drawable.ic_stat_name)
                    .setAutoCancel(true)
                    .setContentIntent(pendingIntent)
                    .setContentText(message);

            NotificationManagerCompat manager = NotificationManagerCompat.from(this);
            manager.notify(1,builder.build());
        }
    }
}
