package com.strategair.search.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.strategair.search.adapter.holder.SearchHolder
import com.strategair.search.model.SearchResult

class GlobalSearchAdapter : RecyclerView.Adapter<SearchHolder>() {

    private val list = ArrayList<SearchResult>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
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
