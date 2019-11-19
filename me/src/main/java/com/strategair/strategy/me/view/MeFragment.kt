package com.strategair.strategy.me.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.strategair.strategy.common.component.BaseFragment
import com.strategair.strategy.me.R

class MeFragment : BaseFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_me, container, false)
    }
}
