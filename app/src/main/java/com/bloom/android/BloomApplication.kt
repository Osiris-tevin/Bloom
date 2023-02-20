package com.bloom.android

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

class BloomApplication : Application() {

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }

}