package com.burak

import android.app.Application
import android.content.Context
import com.orhanobut.hawk.Hawk

class MainApp : Application() {

    override fun onCreate() {
        super.onCreate()
        Hawk.init(this).build()
    }

    init {
        instance = this
    }

    companion object {
        var instance: MainApp? = null
    }

}