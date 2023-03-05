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
            setWatchfaceColor(R.color.pink)
            setBorderColor(R.color.blue)
            setHandsColor(R.color.yellow)
            setSecondsHandColor(R.color.cyan)
            setTextColor(R.color.green)
            setTextSize(32f)
        }
    }
}