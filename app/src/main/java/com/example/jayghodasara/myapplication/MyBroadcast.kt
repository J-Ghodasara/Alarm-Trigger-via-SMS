package com.example.jayghodasara.myapplication

import android.app.*
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.telephony.SmsMessage
import android.widget.Toast


class MyBroadcast : BroadcastReceiver() {


    lateinit var message: String

    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(context, "Broadcast receiver of app2", Toast.LENGTH_LONG).show()


        var data: Bundle? = intent!!.extras

        if (data != null) {
            var pdus = data.get("pdus") as Array<*>
            for (i in pdus.indices) {
                val format = data.get("format")
                var smsMessage = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    SmsMessage.createFromPdu(pdus[i] as ByteArray, format as String?)
                } else {
                    SmsMessage.createFromPdu(pdus[i] as ByteArray)
                }

                message = smsMessage.messageBody.toString()
                Toast.makeText(context, message, Toast.LENGTH_LONG).show()
            }

            if (message == "set an alarm") {


                val am = context!!.getSystemService(Context.ALARM_SERVICE) as AlarmManager

                //creating a new intent specifying the broadcast receiver
                val i = Intent(context, Ring::class.java)

                //creating a pending intent using the intent
                val pi = PendingIntent.getBroadcast(context, 0, i, 0)

                //setting the repeating alarm that will be fired every day
                am.setRepeating(AlarmManager.RTC, 5000, 60000 * 10, pi)
                Toast.makeText(context, "Alarm is set", Toast.LENGTH_SHORT).show()


            }


        }


    }


}