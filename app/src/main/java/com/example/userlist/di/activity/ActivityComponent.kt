package com.example.userlist.di.activity

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import com.example.userlist.ui.UserActivity
import dagger.BindsInstance
import dagger.Component
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {
    fun inject(userActivity:  UserActivity)

    @Subcomponent.Builder
    interface Builder {
        @BindsInstance
        fun activity(activity: AppCompatActivity): Builder
        fun build(): ActivityComponent
    }
}