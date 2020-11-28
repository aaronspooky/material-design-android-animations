package io.aaronspooky.android_material_animations.ui.main.list.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ListAdapter(
    private val onClick: (View) -> Unit
): RecyclerView.Adapter<ListViewHolder>() {

    /**
     *
     */
    override fun getItemCount(): Int = 5

    /**
     *
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder.from(parent)
    }

    /**
     *
     */
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(onClick)
    }
}