package hr.ferit.mlenic.countingbirds

import android.app.Application
import android.content.Context

class BirdCounterApp: Application() {
    companion object{
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = this
    }

}