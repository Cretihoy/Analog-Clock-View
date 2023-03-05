package com.example.analogclockview

import android.content.Context
import android.graphics.Paint
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

    private var paint = Paint()
    private var isInitialized = false

    private var watchfaceColor = getColor(R.color.defaultWatchfaceColor)
    private var borderColor = getColor(R.color.defaultBorderColor)
    private var handsColor = getColor(R.color.defaultHandsColor)
    private var secondsHandColor = getColor(R.color.defaultSecondsHandsColor)
    private var textColor = getColor(R.color.defaultTextColor)

    private var textFontSize = resources.makeSp(18f)
    private val handSize = resources.makeDp(4f)

    // region public methods
    fun setWatchfaceColor(@ColorRes value: Int) {
        watchfaceColor = getColor(value)
    }

    fun setBorderColor(@ColorRes value: Int) {
        borderColor = getColor(value)
    }

    fun setHandsColor(@ColorRes value: Int) {
        handsColor = getColor(value)
    }

    fun setSecondsHandColor(@ColorRes value: Int) {
        secondsHandColor = getColor(value)
    }

    fun setTextColor(@ColorRes value: Int) {
        textColor = getColor(value)
    }

    fun setTextSize(value: Float) {
        textFontSize = resources.makeSp(value)
    }
    // endregion

    private fun getColor(@ColorRes color: Int): Int {
        return ContextCompat.getColor(context, color)
    }
}