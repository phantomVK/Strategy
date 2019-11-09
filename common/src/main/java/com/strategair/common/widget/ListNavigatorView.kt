package com.strategair.common.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.strategair.common.R
import com.strategair.common.service.sp
import kotlin.math.floor

class ListNavigatorView @JvmOverloads
constructor(context: Context, attrs: AttributeSet? = null, defStyle: Int = 0) :
    View(context, attrs, defStyle) {

    private var mFontSpace = 0F
    private var mOldIndex = -1

    private var mBackground = 0
    private var mBackgroundPressed = 0

    private val mPaint = Paint()
    private val mPaintPressed = Paint()
    private val mCharacters = mutableListOf<String>()
    private var mListener: OnTouchListener? = null

    init {
        val a = context.obtainStyledAttributes(attrs, R.styleable.ListNavigatorView)
        val textSize = a.getDimension(R.styleable.ListNavigatorView_textSize, sp(12.5F))
        val textSizePressed = a.getDimension(R.styleable.ListNavigatorView_textSizePressed, sp(16F))
        val textColor = a.getColor(R.styleable.ListNavigatorView_textColor, -0xcc9a68)
        val textColorPressed = a.getColor(R.styleable.ListNavigatorView_textColorPressed, -0xcc6601)
        val textSpanScale = a.getFloat(R.styleable.ListNavigatorView_textSpanScale, 0.2F)
        mBackground = a.getColor(R.styleable.ListNavigatorView_background, Color.TRANSPARENT)
        mBackgroundPressed = a.getColor(R.styleable.ListNavigatorView_backgroundPressed, 0x53d3d3d3)
        a.recycle()

        mPaint.isAntiAlias = true
        mPaint.textSize = textSize
        mPaint.color = textColor

        mPaintPressed.isAntiAlias = true
        mPaintPressed.textSize = textSizePressed
        mPaintPressed.color = textColorPressed
        mPaintPressed.isFakeBoldText = true

        val metrics = mPaint.fontMetrics
        mFontSpace = (metrics.descent - metrics.ascent) * (1F + textSpanScale)
    }

    override fun onDraw(canvas: Canvas) {
        if (mCharacters.isEmpty()) {
            if (isInEditMode) inEditModePreview() else return
        }

        val w = measuredWidth shr 1
        var yPos = getYPosition()
        for ((index, value) in mCharacters.withIndex()) {
            val p = if (mOldIndex == index) mPaintPressed else mPaint
            canvas.drawText(value, w - p.measureText(value) / 2, yPos, p)
            yPos += mFontSpace
        }
    }

    override fun dispatchTouchEvent(event: MotionEvent): Boolean {
        if (mCharacters.isEmpty()) return super.dispatchTouchEvent(event)

        val action = event.action
        if (action == MotionEvent.ACTION_UP || action == MotionEvent.ACTION_CANCEL) {
            mOldIndex = -1
            mListener?.onTouch(this, null)
            setBackgroundColor(mBackground)
            return true
        }

        val newIndex = floor((event.y - getYPosition()) / mFontSpace).toInt() + 1
        if (mOldIndex != newIndex && 0 <= newIndex && newIndex < mCharacters.size) {
            mOldIndex = newIndex
            mListener?.onTouch(this, mCharacters[mOldIndex])
            setBackgroundColor(mBackgroundPressed)
            invalidate()
        }

        return true
    }

    private fun getYPosition(): Float {
        return (measuredHeight - mFontSpace * mCharacters.size) / 2
    }

    private fun inEditModePreview() {
        setBackgroundColor(mBackgroundPressed)
        mOldIndex = 7
        mCharacters.apply {
            add("#");add("A");add("B");add("C");add("D");add("E");add("F");add("G");add("H")
            add("I");add("J");add("K");add("L");add("M");add("N");add("O");add("P");add("Q")
            add("R");add("S");add("T");add("U");add("V");add("W");add("X");add("Y");add("Z")
        }
    }

    fun clear() = mCharacters.clear()
    fun add(element: String) = mCharacters.add(element)
    fun addAll(elements: Collection<String>) = mCharacters.addAll(elements)
    fun setListener(listener: OnTouchListener?) = run { mListener = listener }

    interface OnTouchListener {
        fun onTouch(view: View, string: String?)
    }
}