package com.example.analogclockview

import android.content.res.Resources
import android.util.TypedValue

fun Resources.makeDp(value: Float): Float {
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        value,
        this.displayMetrics
    )
}

fun Resources.makeSp(value: Float): Float {
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_SP,
        value,
        this.displayMetrics
    )
}