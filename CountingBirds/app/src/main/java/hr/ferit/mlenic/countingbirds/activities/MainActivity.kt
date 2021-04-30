package hr.ferit.mlenic.countingbirds.activities

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import hr.ferit.mlenic.countingbirds.PreferenceManager
import hr.ferit.mlenic.countingbirds.R
import hr.ferit.mlenic.countingbirds.databinding.ActivityMainBinding
import hr.ferit.mlenic.countingbirds.model.BirdsCounter
const val PREFS_KEY_COUNTER = "NumberOfBirds"
const val PREFS_KEY_BACKGROUND = "Color"
class MainActivity : AppCompatActivity() {


    private lateinit var mainBinding: ActivityMainBinding
    private val birdsCounter = BirdsCounter()
    private val prefs = PreferenceManager()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        mainBinding.btnRed.setOnClickListener { seeRedBird() }
        mainBinding.btnBlue.setOnClickListener { seeBlueBird() }
        mainBinding.btnGreen.setOnClickListener { seeGreenBird() }
        mainBinding.btnYellow.setOnClickListener { seeYellowBird() }
        mainBinding.btnReset.setOnClickListener { resetCounter() }

        displayData()
        setContentView(mainBinding.root)

        birdsCounter.numOfBirds = prefs.sharedPreferences.getInt(PREFS_KEY_COUNTER, 0)
        mainBinding.tvCounter.setBackgroundColor(
            Color.parseColor(prefs.sharedPreferences.getString(PREFS_KEY_BACKGROUND, "#FFFFFF")))
    }

    private fun displayData() {
        val sum = prefs.sharedPreferences.getInt(PREFS_KEY_COUNTER, 0)
        val backgroundColor = prefs.sharedPreferences.getString(PREFS_KEY_BACKGROUND, "#FFFFFF")
        mainBinding.tvCounter.text = sum.toString()
        mainBinding.tvCounter.setBackgroundColor(Color.parseColor(backgroundColor))
    }

    private fun resetCounter() {
        birdsCounter.numOfBirds = 0
        mainBinding.tvCounter.text =birdsCounter.numOfBirds.toString()
        mainBinding.tvCounter.setBackgroundColor(Color.parseColor("#FFFFFF"))
        prefs.editor.apply {
            putInt(PREFS_KEY_COUNTER, 0)
            putString(PREFS_KEY_BACKGROUND, "#FFFFFF")
        }.apply()
    }

    private fun seeYellowBird() {
        birdsCounter.seeYellowBird()
        mainBinding.tvCounter.text = birdsCounter.numOfBirds.toString()
        mainBinding.tvCounter.setBackgroundColor(Color.parseColor("#FFFF00"))
        prefs.editor.apply {
            putInt(PREFS_KEY_COUNTER, birdsCounter.numOfBirds)
            putString(PREFS_KEY_BACKGROUND, "#FFFF00")
        }.apply()
    }

    private fun seeGreenBird() {
        birdsCounter.seeGreenBird()
        mainBinding.tvCounter.text = birdsCounter.numOfBirds.toString()
        mainBinding.tvCounter.setBackgroundColor(Color.parseColor("#008000"))
        prefs.editor.apply {
            putInt(PREFS_KEY_COUNTER, birdsCounter.numOfBirds)
            putString(PREFS_KEY_BACKGROUND, "#008000")
        }.apply()
    }

    private fun seeBlueBird() {
        birdsCounter.seeBlueBird()
        mainBinding.tvCounter.text = birdsCounter.numOfBirds.toString()
        mainBinding.tvCounter.setBackgroundColor(Color.parseColor("#0000FF"))
        prefs.editor.apply {
            putInt(PREFS_KEY_COUNTER, birdsCounter.numOfBirds)
            putString(PREFS_KEY_BACKGROUND, "#0000FF")
        }.apply()

    }

    private fun seeRedBird() {
        birdsCounter.seeRedBird()
        mainBinding.tvCounter.text = birdsCounter.numOfBirds.toString()
        mainBinding.tvCounter.setBackgroundColor(Color.parseColor("#FF0000"))
        prefs.editor.apply {
            putInt(PREFS_KEY_COUNTER, birdsCounter.numOfBirds)
            putString(PREFS_KEY_BACKGROUND, "#FF0000")
        }.apply()
    }

}

