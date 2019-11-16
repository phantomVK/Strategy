package com.strategair.strategy.search.adapter

import android.app.Activity
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.strategair.strategy.search.R
import com.strategair.strategy.search.adapter.holder.SearchHolder
import com.strategair.strategy.search.model.SearchResult

class GlobalSearchAdapter(private val activity: Activity) : RecyclerView.Adapter<SearchHolder>() {

    private val list = ArrayList<SearchResult>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchHolder {
        return SearchHolder(activity.layoutInflater.inflate(R.layout.item_global_search, parent))
    }

    override fun getItemCount() = list.size
    override fun onBindViewHolder(holder: SearchHolder, position: Int) {
        holder.onBind(list[position])
    }

    fun addAll(elements: Collection<SearchResult>) {
        list.addAll(elements)
        notifyItemRangeInserted(0, elements.size)
    }

    fun clear() {
        notifyItemRangeRemoved(0, list.size)
        list.clear()
    }
}
