package com.example.analogclockview

import android.content.res.Resources
import android.util.TypedValue

fun Float.half(): Float {
    return this / 2
}

fun Int.half(): Int {
    return this / 2
}

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