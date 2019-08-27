package com.example.footballapi

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.widget.Toast

class ExampleBroadcastReciever :BroadcastReceiver(){
    override fun onReceive(p0: Context?, p1: Intent?) {
        if (Intent.ACTION_BOOT_COMPLETED.equals(p1?.action)){
            Toast.makeText(p0, "boot completed", Toast.LENGTH_SHORT).show()

        }

        if (ConnectivityManager.ACTION_CAPTIVE_PORTAL_SIGN_IN.equals(p1?.action)){
            Toast.makeText(p0, "connectivity changed", Toast.LENGTH_SHORT).show()
        }

    }

}