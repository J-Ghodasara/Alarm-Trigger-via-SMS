package com.example.jayghodasara.myapplication

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import android.support.annotation.RequiresApi
import android.util.Log

class Ring: BroadcastReceiver(){

    lateinit var notificationManager:NotificationManager
    lateinit var notificationchannel:NotificationChannel
    lateinit var builder:Notification.Builder
    private val channelid= "com.example.jayghodasara.myapplication"
    private val desc="test"


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onReceive(context: Context?, intent: Intent?) {

        Log.i("Ring","Called")
        val notificationIntent = Intent(context, Main2Activity::class.java)
        val pendingIntent = PendingIntent.getActivity(context, 0,
                notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT )


        notificationManager=context!!.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        notificationchannel= NotificationChannel(channelid,desc, NotificationManager.IMPORTANCE_HIGH)
        notificationchannel.enableLights(true)
        notificationchannel.lightColor =  Color.BLUE
        notificationchannel.setShowBadge(true)
        notificationchannel.enableVibration(false)
        notificationManager.createNotificationChannel(notificationchannel)
        builder= Notification.Builder(context,channelid)
                .setContentTitle("Alarm Ringing")
                .setContentText("Ringing")
                .setColorized(true)
                .setColor(context.resources.getColor(R.color.colorPrimary))
                .setGroup("com.android.example.WORK_EMAIL")
                .setSmallIcon(R.drawable.notification_icon_background)
                .setLargeIcon(BitmapFactory.decodeResource(context.resources,R.drawable.notification_icon_background))
                .setContentIntent(pendingIntent)


        notificationManager.notify(123,builder.build())


    }

}