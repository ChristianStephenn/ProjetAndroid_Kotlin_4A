package com.example.projetandroid_kotlin_4a.injection

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate(){
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(presentationModule, dataModule, domainModule)
        }
    }
}