package com.olehka.cleanandroid.feature.planetary.ui

import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.olehka.cleanandroid.R
import com.olehka.cleanandroid.core.extension.inflate
import com.olehka.cleanandroid.databinding.RowPictureBinding
import javax.inject.Inject
import kotlin.properties.Delegates

class PicturesAdapter @Inject constructor() : RecyclerView.Adapter<PicturesAdapter.ViewHolder>() {
    internal var collection: List<PictureView> by Delegates.observable(emptyList()) { _, _, _ ->
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(pictureView: PictureView) {
            Log.d("PicturesAdapter", "load: ${pictureView.url}")
            val binding = RowPictureBinding.bind(itemView)
            binding.title.text = pictureView.title
            binding.image.load(pictureView.url)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.inflate(R.layout.row_picture))
    }

    override fun getItemCount(): Int {
        return collection.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(collection[position])
    }
}
