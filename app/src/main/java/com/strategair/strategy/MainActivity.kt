package com.strategair.strategy

import android.os.Bundle
import com.strategair.common.component.BaseActivity
import com.strategair.common.widget.ListNavigatorView

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val set = mutableSetOf<String>().apply {
            add("!");add("A");add("B");add("C");add("D");add("E");add("F");add("G");add("H");add("I")
            add("J");add("K");add("L");add("M");add("N");add("O");add("P");add("R");add("S");add("T")
            add("U");add("V");add("W");add("X");add("Y");add("Z");add("#");add("A");add("B");add("C")
        }

        findViewById<ListNavigatorView>(R.id.navigator).apply {
            addAll(set)
            invalidate()
        }
    }

    override fun slideBackDisable() = true
}
