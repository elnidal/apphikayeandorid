package com.hepsihikaye.android.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hepsihikaye.android.R
import com.hepsihikaye.android.model.Post

/**
 * Adapter for featured posts in a horizontal RecyclerView
 */
class FeaturedPostsAdapter(private val onPostClick: (Int) -> Unit) :
    ListAdapter<Post, FeaturedPostsAdapter.FeaturedPostViewHolder>(FeaturedPostDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeaturedPostViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_featured_post, parent, false)
        return FeaturedPostViewHolder(view)
    }

    override fun onBindViewHolder(holder: FeaturedPostViewHolder, position: Int) {
        val post = getItem(position)
        holder.bind(post)
    }

    inner class FeaturedPostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.featuredImage)
        private val titleTextView: TextView = itemView.findViewById(R.id.featuredTitle)
        private val categoryTextView: TextView = itemView.findViewById(R.id.featuredCategory)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    onPostClick(getItem(position).id)
                }
            }
        }

        fun bind(post: Post) {
            titleTextView.text = post.title
            categoryTextView.text = post.getCategoryDisplay()
            
            // Load image if available
            post.getFullImageUrl()?.let { imageUrl ->
                Glide.with(itemView.context)
                    .load(imageUrl)
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .error(R.drawable.ic_launcher_foreground)
                    .centerCrop()
                    .into(imageView)
            } ?: run {
                // Use placeholder if no image
                imageView.setImageResource(R.drawable.ic_launcher_foreground)
            }
        }
    }

    private class FeaturedPostDiffCallback : DiffUtil.ItemCallback<Post>() {
        override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
            return oldItem == newItem
        }
    }
} 