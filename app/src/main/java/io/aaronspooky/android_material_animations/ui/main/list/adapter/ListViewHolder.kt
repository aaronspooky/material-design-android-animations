package io.aaronspooky.android_material_animations.ui.main.list.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.TransitionManager
import com.google.android.material.transition.MaterialContainerTransform
import io.aaronspooky.android_material_animations.databinding.ItemSimpleRowBinding

class ListViewHolder(
    private val binding: ItemSimpleRowBinding
    ): RecyclerView.ViewHolder(binding.root) {

    fun bind(onClick: (View) -> Unit) {
        binding.root.setOnClickListener {
            onClick(binding.root)
        }
    }

    /**
     *
     */
    companion object {
            fun from(parent: ViewGroup): ListViewHolder {
                val layoutInflater = ItemSimpleRowBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return ListViewHolder(layoutInflater)
            }
        }
}