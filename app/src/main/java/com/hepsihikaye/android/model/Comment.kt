package com.hepsihikaye.android.model

import com.google.gson.annotations.SerializedName
import java.util.Date

/**
 * Represents a user comment on a post
 */
data class Comment(
    @SerializedName("id")
    val id: Int,
    
    @SerializedName("post_id")
    val postId: Int,
    
    @SerializedName("author")
    val author: String,
    
    @SerializedName("content")
    val content: String,
    
    @SerializedName("created_at")
    val createdAt: Date,
    
    @SerializedName("is_approved")
    val isApproved: Boolean
) 