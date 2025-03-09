package com.hepsihikaye.android.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.util.Date

/**
 * Represents a story or article post in the app
 */
data class Post(
    @SerializedName("id")
    val id: Int,
    
    @SerializedName("title")
    val title: String,
    
    @SerializedName("content")
    val content: String,
    
    @SerializedName("category")
    val category: String,
    
    @SerializedName("created_at")
    val createdAt: Date,
    
    @SerializedName("author")
    val author: String?,
    
    @SerializedName("image_url")
    val imageUrl: String?,
    
    @SerializedName("likes")
    val likes: Int,
    
    @SerializedName("dislikes")
    val dislikes: Int,
    
    @SerializedName("comment_count")
    val commentCount: Int = 0
) : Serializable {
    
    /**
     * Returns the formatted display name for the category
     */
    fun getCategoryDisplay(): String {
        return when (category) {
            "story" -> "Öykü"
            "article" -> "Makale"
            "poem" -> "Şiir"
            "video" -> "Video"
            else -> category.capitalize()
        }
    }
    
    /**
     * Returns the full image URL including the domain
     */
    fun getFullImageUrl(): String? {
        return if (imageUrl.isNullOrEmpty()) {
            null
        } else {
            // Assuming we will store the base URL in a constants file
            "https://hepsihikaye.net" + imageUrl
        }
    }
}

// Helper extension function to capitalize the first letter
private fun String.capitalize(): String {
    return if (this.isNotEmpty()) {
        this[0].uppercase() + this.substring(1)
    } else {
        this
    }
} 