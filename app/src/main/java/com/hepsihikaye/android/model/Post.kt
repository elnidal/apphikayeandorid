package com.hepsihikaye.android.model

import java.util.Date

/**
 * Represents a story or article post in the app
 */
data class Post(
    val id: Int,
    val title: String,
    val content: String,
    val image: String?,
    val category: String,
    val createdAt: Date,
    val likes: Int = 0,
    val views: Int = 0
) {
    
    /**
     * Returns the formatted display name for the category
     */
    fun getCategoryDisplay(): String = category.replaceFirstChar { it.uppercase() }
    
    /**
     * Returns the full image URL including the domain
     */
    fun getFullImageUrl(): String? = image?.let { "https://hepsihikaye.com$it" }
}

// Helper extension function to capitalize the first letter
private fun String.capitalize(): String {
    return if (this.isNotEmpty()) {
        this[0].uppercase() + this.substring(1)
    } else {
        this
    }
} 