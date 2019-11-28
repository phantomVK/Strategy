package com.strategair.strategy.view.home

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.strategair.strategy.R
import com.strategair.strategy.common.component.BaseActivity
import com.strategair.strategy.home.view.HomeFragment
import com.strategair.strategy.me.view.MeFragment
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val pagerAdapter = HomePagerAdapter(supportFragmentManager)
        pagerAdapter.addFragments(listOf<Fragment>(HomeFragment(), HomeFragment(), HomeFragment(), MeFragment()))
        pager.adapter = pagerAdapter
        group.setViewPager(pager)
    }

    override fun slideBackDisable() = true

    override fun initToolbar() {
        val bar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(bar)
    }

    companion object {
        fun startActivity(activity: AppCompatActivity) {
            Intent(activity, HomeActivity::class.java)
                .run { activity.startActivity(this) }
        }
    }
}
