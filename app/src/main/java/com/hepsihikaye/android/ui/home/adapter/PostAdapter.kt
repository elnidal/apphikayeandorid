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
 * Adapter for standard post list items in a vertical RecyclerView
 */
class PostAdapter(private val onPostClick: (Int) -> Unit) :
    ListAdapter<Post, PostAdapter.PostViewHolder>(PostDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_post, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = getItem(position)
        holder.bind(post)
    }

    inner class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.postImage)
        private val titleTextView: TextView = itemView.findViewById(R.id.postTitle)
        private val categoryTextView: TextView = itemView.findViewById(R.id.postCategory)
        private val dateTextView: TextView = itemView.findViewById(R.id.postDate)
        private val excerptTextView: TextView = itemView.findViewById(R.id.postExcerpt)

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
            
            // Format date
            val dateStr = post.createdAt.toString()
            dateTextView.text = dateStr
            
            // Set excerpt
            excerptTextView.text = post.content
                .replace(Regex("<.*?>"), "") // Remove HTML tags
                .take(100) + if (post.content.length > 100) "..." else ""
            
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

    private class PostDiffCallback : DiffUtil.ItemCallback<Post>() {
        override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
            return oldItem == newItem
        }
    }
} 