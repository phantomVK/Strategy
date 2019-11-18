package com.strategair.strategy.common.delegate

import com.strategair.strategy.common.listener.OnDoubleClickListener

class DoubleClickDelegate {

    private val listeners = ArrayList<OnDoubleClickListener>()

    fun add(l: OnDoubleClickListener?) {
        if (l != null && l !in listeners) listeners.add(l)
    }

    fun remove(l: OnDoubleClickListener?) {
        if (l != null) listeners.remove(l)
    }

    fun clear() {
        listeners.clear()
        listeners.trimToSize()
    }

    fun publish() {
        for (l in listeners) l.onDoubleClicked()
    }
}
