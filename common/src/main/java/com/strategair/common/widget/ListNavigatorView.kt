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

class ListNavigatorView @JvmOverloads
constructor(context: Context, attrs: AttributeSet? = null, defStyle: Int = 0)
    : View(context, attrs, defStyle) {

    private var mFontHeight = 0F
    private var mCurrIndex = -1

    private var mTextColor = 0
    private var mTextColorPressed = 0
    private var mTextSpanScale = 0F

    private var mBackground = 0
    private var mBackgroundPressed = 0

    private val mPaint = Paint()
    private val mPaintPressed = Paint()
    private val mCharacters = mutableListOf<String>()
    private var mListener: OnTouchListener? = null

    init {
        val a = context.obtainStyledAttributes(attrs, R.styleable.ListNavigatorView)
        val textSize = a.getDimension(R.styleable.ListNavigatorView_textSize, sp(12F))
        val textSizePressed = a.getFloat(R.styleable.ListNavigatorView_textSizePressed, sp(14.5F))
        mTextColor = a.getColor(R.styleable.ListNavigatorView_textColor, -0xcc9a68)
        mTextColorPressed = a.getColor(R.styleable.ListNavigatorView_textColorPressed, -0xcc6601)
        mTextSpanScale = a.getFloat(R.styleable.ListNavigatorView_textSpanScale, 0.2F)
        mBackground = a.getColor(R.styleable.ListNavigatorView_background, Color.TRANSPARENT)
        mBackgroundPressed = a.getColor(R.styleable.ListNavigatorView_backgroundPressed, 0x53d3d3d3)
        a.recycle()

        mPaint.isAntiAlias = true
        mPaint.textSize = textSize
        mPaint.color = mTextColor

        mPaintPressed.isAntiAlias = true
        mPaintPressed.textSize = textSizePressed
        mPaintPressed.color = mTextColorPressed
        mPaintPressed.isFakeBoldText = true

        val metrics = mPaint.fontMetrics
        mFontHeight = (metrics.descent - metrics.ascent) * (1F + mTextSpanScale)
    }

    override fun onDraw(canvas: Canvas) {
        if (mCharacters.isEmpty()) return

        for ((index, value) in mCharacters.withIndex()) {
            val p = if (mCurrIndex == index) mPaintPressed else mPaint
            val xPos = (measuredWidth shr 1) - p.measureText(value) / 2
            val yPos = getTopPosition() + index * mFontHeight
            canvas.drawText(value, xPos, yPos, p)
        }
    }

    override fun dispatchTouchEvent(event: MotionEvent): Boolean {
        if (mCharacters.isEmpty()) {
            return super.dispatchTouchEvent(event)
        }

        if (event.action == MotionEvent.ACTION_UP || event.action == MotionEvent.ACTION_CANCEL) {
            mCurrIndex = -1
            mListener?.onTouch(this, null)
            setBackgroundColor(mBackground)
            return true
        }

        val newIndex = ((event.y - getTopPosition()) / mFontHeight).toInt() + 1
        if (newIndex != mCurrIndex && 0 <= newIndex && newIndex < mCharacters.size) {
            mCurrIndex = newIndex
            mListener?.onTouch(this, mCharacters[newIndex])
            setBackgroundColor(mBackgroundPressed)
        } else {
            invalidate()
        }

        return true
    }

    private fun getTopPosition(): Float {
        return (measuredHeight - mFontHeight * (mCharacters.size + mTextSpanScale)) / 2
    }

    fun clear() = mCharacters.clear()
    fun add(element: String) = mCharacters.add(element)
    fun addAll(elements: Collection<String>) = mCharacters.addAll(elements)
    fun setListener(listener: OnTouchListener) = run { mListener = listener }

    interface OnTouchListener {
        fun onTouch(view: View, string: String?)
    }
}
