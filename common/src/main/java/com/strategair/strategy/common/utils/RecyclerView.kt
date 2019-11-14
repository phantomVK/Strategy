package com.strategair.strategy.common.utils

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.InsetDrawable
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.strategair.strategy.common.service.dp

fun verticalItemDecoration(context: Context,
                           color: Int = Color.parseColor("#d8d8da"),
                           height: Int = context.dp(0.5F).toInt(),
                           inset: Int = context.dp(10)): DividerItemDecoration {

    val g = GradientDrawable()
    g.setSize(-1, height)
    g.setColor(color)

    val d = DividerItemDecoration(context, RecyclerView.VERTICAL)
    d.setDrawable(InsetDrawable(g, inset, 0, 0, 0))
    return d
}
