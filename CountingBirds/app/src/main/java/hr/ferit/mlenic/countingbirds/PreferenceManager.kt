package hr.ferit.mlenic.countingbirds

import android.content.Context
import android.content.SharedPreferences
import hr.ferit.mlenic.countingbirds.BirdCounterApp.Companion.context


const val PREFS_FILE = "MyPreferences"
class PreferenceManager {

    val sharedPreferences = context.getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE)
    val editor = sharedPreferences.edit()
}