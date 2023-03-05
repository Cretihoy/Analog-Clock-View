package com.example.analogclockview

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.annotation.ColorRes

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
}