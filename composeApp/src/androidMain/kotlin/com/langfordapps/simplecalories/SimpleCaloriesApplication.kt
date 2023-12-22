package com.langfordapps.simplecalories

import android.app.Application
import di.KoinHelper
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger

class SimpleCaloriesApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        KoinHelper.doInit {
            androidContext(this@SimpleCaloriesApplication)
            androidLogger()
        }
    }
}
