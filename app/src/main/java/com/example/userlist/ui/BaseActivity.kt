package com.example.userlist.ui


import androidx.appcompat.app.AppCompatActivity
import com.example.userlist.MyApplication

open class BaseActivity : AppCompatActivity(){
    private val appComponent get() = (application as MyApplication).appComponent

    val activityComponent by lazy {
        appComponent.newActivityComponentBuilder()
            .activity(this)
            .build()
    }
}