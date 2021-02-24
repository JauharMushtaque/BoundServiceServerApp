package com.example.service.serverapp

import android.annotation.SuppressLint
import android.app.Service
import android.content.Intent
import android.os.*

class RemoteServiceByMessenger : Service() {
    private val requestHandler=object :Handler(){
        @SuppressLint("HandlerLeak")
        override fun handleMessage(msg:Message){
            var bundle = Bundle()
            bundle.putString("jauhar", "Hi BoundServiceClientApp, this is from BoundServiceServerApp")
            msg.data = bundle
        }
    }
    private var myRequestMessenger=Messenger(requestHandler)

    override fun onBind(intent: Intent): IBinder {
        return myRequestMessenger.binder
    }

     fun sayHiToActivity():String{
        return "Hi MainActivity, this is from Service"
    }
}