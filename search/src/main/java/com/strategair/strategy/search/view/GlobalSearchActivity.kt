package com.strategair.strategy.search.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.strategair.strategy.common.component.ImmersiveActivity
import com.strategair.strategy.common.utils.verticalItemDecoration
import com.strategair.strategy.search.R
import com.strategair.strategy.search.adapter.GlobalSearchAdapter
import kotlinx.android.synthetic.main.activity_global_search.*

@Route(path = "/search/GlobalSearchActivity")
class GlobalSearchActivity : ImmersiveActivity() {

    private lateinit var mAdapter: GlobalSearchAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_global_search)

        val llm = LinearLayoutManager(this).apply { isSmoothScrollbarEnabled = true }
        mAdapter = GlobalSearchAdapter(this)
        recyclerView.adapter = mAdapter
        recyclerView.layoutManager = llm
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
