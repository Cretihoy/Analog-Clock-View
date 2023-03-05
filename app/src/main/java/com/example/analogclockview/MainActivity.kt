package com.example.analogclockview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val clock: AnalogClockView by lazy { findViewById(R.id.clock) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        customizeClock()
    }

    private fun customizeClock() {
        clock.run {
            setWatchfaceColor(R.color.white)
            setBorderColor(R.color.pink)
            setHandsColor(R.color.yellow)
            setSecondsHandColor(R.color.cyan)
            setTextColor(R.color.black)
            setTextSize(32f)
        }
    }
}