package com.hepsihikaye.android.model

import com.google.gson.annotations.SerializedName
import java.util.Date

/**
 * Represents a video in the app
 */
data class Video(
    @SerializedName("id")
    val id: Int,
    
    @SerializedName("title")
    val title: String,
    
    @SerializedName("description")
    val description: String?,
    
    @SerializedName("youtube_embed")
    val youtubeEmbed: String,
    
    @SerializedName("created_at")
    val createdAt: Date
) {
    /**
     * Returns the YouTube thumbnail URL for this video
     */
    fun getThumbnailUrl(): String {
        return "https://img.youtube.com/vi/$youtubeEmbed/hqdefault.jpg"
    }
    
    /**
     * Returns the full YouTube video URL
     */
    fun getYoutubeUrl(): String {
        return "https://www.youtube.com/watch?v=$youtubeEmbed"
    }
} 