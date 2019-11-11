package com.strategair.search.adapter.holder

import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.strategair.common.component.WebViewActivity
import com.strategair.search.R
import com.strategair.search.model.SearchResult

class SearchHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val titleView = itemView.findViewById<AppCompatTextView>(R.id.title)
    private val dateView = itemView.findViewById<AppCompatTextView>(R.id.date)

    fun onBind(result: SearchResult) {
        titleView.text = result.title
        dateView.text = result.date
        itemView.setOnClickListener { WebViewActivity.startActivity(itemView.context, result.url) }
    }
}
