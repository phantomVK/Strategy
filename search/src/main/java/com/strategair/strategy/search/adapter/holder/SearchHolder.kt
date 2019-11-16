package com.strategair.strategy.search.adapter.holder

import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.strategair.strategy.common.component.WebViewActivity
import com.strategair.strategy.search.R
import com.strategair.strategy.search.model.SearchResult

class SearchHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val titleView = itemView.findViewById<AppCompatTextView>(R.id.title)
    private val source = itemView.findViewById<AppCompatTextView>(R.id.source)
    private val author = itemView.findViewById<AppCompatTextView>(R.id.author)
    private val dateView = itemView.findViewById<AppCompatTextView>(R.id.date)

    fun onBind(result: SearchResult) {
        titleView.text = result.title
        dateView.text = result.date
        source.text = result.source
        author.text = result.author
        itemView.setOnClickListener { WebViewActivity.startActivity(itemView.context, result.url) }
    }
}
