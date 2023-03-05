package com.example.analogclockview

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat

class AnalogClockView(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(
    context,
    attributeSet,
    defStyleAttr
) {

    constructor(context: Context, attributeSet: AttributeSet?) : this(context, attributeSet, 0)
    constructor(context: Context) : this(context, null)

    private var clockHeight = 0
    private var clockWidth = 0
    private var clockRadius = 0

    private var watchfaceColor = getColor(R.color.defaultWatchfaceColor)
    private var borderColor = getColor(R.color.defaultBorderColor)
    private var handsColor = getColor(R.color.defaultHandsColor)
    private var secondsHandColor = getColor(R.color.defaultSecondsHandsColor)
    private var textColor = getColor(R.color.defaultTextColor)

    fun setWatchfaceColor(@ColorRes value: Int) {
        // TODO
    }

    fun setBorderColor(@ColorRes value: Int) {
        // TODO
    }

    fun setHandsColor(@ColorRes value: Int) {
        // TODO
    }

    fun setSecondsHandColor(@ColorRes value: Int) {
        // TODO
    }

    fun setTextColor(value: Int) {
        // TODO
    }

    fun setTextSize(value: Float) {
        // TODO
    }

    private fun getColor(@ColorRes color: Int): Int {
        return ContextCompat.getColor(context, color)
    }
}