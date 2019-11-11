package com.strategair.search.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.strategair.common.component.ImmersiveActivity
import com.strategair.common.utils.verticalItemDecoration
import com.strategair.search.R
import com.strategair.search.adapter.GlobalSearchAdapter
import kotlinx.android.synthetic.main.activity_global_search.*

class GlobalSearchActivity : ImmersiveActivity() {

    private val mAdapter = GlobalSearchAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_global_search)

        recyclerView.adapter = mAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(verticalItemDecoration(this))

        cancel.setOnClickListener { finish() }
    }

    companion object {
        fun startActivity(activity: AppCompatActivity) {
            Intent(activity, GlobalSearchActivity::class.java)
                .run { activity.startActivity(this) }
        }
    }

    // Override super.initToolbar()
    override fun initToolbar() {}
}
