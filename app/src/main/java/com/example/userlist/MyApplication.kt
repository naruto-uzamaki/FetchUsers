package com.example.userlist

import android.app.Application
import android.util.Log
import com.example.userlist.di.app.AppComponent
import com.example.userlist.di.app.AppModule
import com.example.userlist.di.app.DaggerAppComponent

class MyApplication : Application() {
    val TAG = "MovieApplication"
    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }

    override fun onCreate() {
        Log.i(TAG, "onCreate: ")
        super.onCreate()
    }
}