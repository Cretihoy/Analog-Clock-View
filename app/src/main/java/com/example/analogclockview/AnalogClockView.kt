package com.example.analogclockview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import java.lang.Integer.min
import kotlin.math.cos
import kotlin.math.sin

private const val BORDER_SIZE = 32f

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

    init {
        setUpAttributes(attributeSet)
    }

    private fun setUpAttributes(attributes: AttributeSet?) {
        val typedArray = context.theme.obtainStyledAttributes(
            attributes,
            R.styleable.AnalogClock,
            0,
            0
        )
        watchfaceColor = getColor(
            typedArray.getResourceId(
                R.styleable.AnalogClock_watchfaceColor,
                R.color.defaultWatchfaceColor
            )
        )
        borderColor = getColor(
            typedArray.getResourceId(
                R.styleable.AnalogClock_borderColor,
                R.color.defaultBorderColor
            )
        )
        handsColor = getColor(
            typedArray.getResourceId(
                R.styleable.AnalogClock_handsColor,
                R.color.defaultHandsColor
            )
        )
        secondsHandColor = getColor(
            typedArray.getResourceId(
                R.styleable.AnalogClock_secondsHandColor,
                R.color.defaultSecondsHandsColor
            )
        )
        textColor = getColor(
            typedArray.getResourceId(
                R.styleable.AnalogClock_textColor,
                R.color.defaultTextColor
            )
        )

        textFontSize = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_PX,
            typedArray.getDimension(R.styleable.AnalogClock_textSize, textFontSize),
            context.resources.displayMetrics
        )
        typedArray.recycle()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        if (!isInitialized) initialize()
        drawClockShape(canvas)
        drawNumbers(canvas)
    }

    private fun initialize() {
        clockHeight = height
        clockWidth = width

        val minHeightWidthValue = min(clockHeight, clockWidth)
        clockRadius = (minHeightWidthValue).half()

        paint.isAntiAlias = true
        isInitialized = true
    }

    private fun drawClockShape(canvas: Canvas) {
        paint.color = watchfaceColor
        canvas.drawCircle(
            clockWidth.half().toFloat(),
            clockHeight.half().toFloat(),
            clockRadius.toFloat(),
            paint
        )

        paint.strokeWidth = BORDER_SIZE
        paint.style = Paint.Style.STROKE
        paint.color = borderColor
        canvas.drawCircle(
            clockWidth.half().toFloat(),
            clockHeight.half().toFloat(),
            clockRadius - BORDER_SIZE.half(),
            paint
        )

        paint.reset()
    }

    private fun drawNumbers(canvas: Canvas) {
        paint.textSize = textFontSize
        paint.isFakeBoldText = true
        paint.color = textColor
        val rect = Rect()
        val innerRadius = clockRadius - BORDER_SIZE * 3

        for (hour in 1..12) {
            val hourString = hour.toString()
            paint.getTextBounds(hourString, 0, hourString.length, rect)
            val angle = Math.PI / 6 * (hour - 3)
            val x = clockWidth.half() + cos(angle) * innerRadius - rect.width().half()
            val y = clockHeight.half().toDouble() + sin(angle) * innerRadius + rect.height().half()

            canvas.drawText(hourString, x.toFloat(), y.toFloat(), paint)
        }
    }

    private fun getColor(@ColorRes color: Int): Int {
        return ContextCompat.getColor(context, color)
    }
}