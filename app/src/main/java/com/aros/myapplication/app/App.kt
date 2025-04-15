package com.aros.myapplication.app

import android.app.Application
import android.content.Context



open class App : Application() {


    companion object {
        fun getApplication(): Context? {
            return context
        }
         var context: Context? = null
    }


    override fun onCreate() {
        super.onCreate()
        context=this

    }

}