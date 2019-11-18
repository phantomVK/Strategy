package com.strategair.strategy.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import androidx.viewpager.widget.ViewPager;

import com.strategair.strategy.common.listener.OnDoubleClickListener;

public class SlideTabLayout extends LinearLayout {

    private ViewPager viewPager;
    private OnDoubleClickListener l;

    public SlideTabLayout(Context context) {
        super(context);
    }

    public SlideTabLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SlideTabLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setOnDoubleClickListener(OnDoubleClickListener listener) {
        l = listener;
    }
}
