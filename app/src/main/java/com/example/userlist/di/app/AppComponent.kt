package com.example.userlist.di.app

import com.example.userlist.MyApplication
import com.example.userlist.di.activity.ActivityComponent
import dagger.Component

@AppScope
@Component(modules = [AppModule::class])
interface AppComponent {
    fun newActivityComponentBuilder(): ActivityComponent.Builder
}