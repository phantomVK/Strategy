package com.strategair.strategy.view.home

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.strategair.strategy.R
import com.strategair.strategy.common.component.BaseActivity
import com.strategair.strategy.me.view.MeFragment
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : BaseActivity() {

    private var pagerAdapter = HomePagerAdapter(supportFragmentManager)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        pager.adapter = pagerAdapter
        pagerAdapter.addFragments(listOf<Fragment>(MeFragment(), MeFragment(), MeFragment(), MeFragment()))
        group.setViewPager(pager)
    }

    companion object {
        fun startActivity(activity: AppCompatActivity) {
            Intent(activity, HomeActivity::class.java)
                .run { activity.startActivity(this) }
        }
    }

    override fun slideBackDisable() = true
}