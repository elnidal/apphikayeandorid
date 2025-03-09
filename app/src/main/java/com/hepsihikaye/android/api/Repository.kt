package com.hepsihikaye.android.api

import com.hepsihikaye.android.model.Comment
import com.hepsihikaye.android.model.Post
import com.hepsihikaye.android.model.Video
import com.hepsihikaye.android.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Repository to handle all network operations
 */
class Repository {
    private val apiService = ApiClient.apiService
    
    /**
     * Get data for the home screen
     */
    suspend fun getHomeData(): Resource<HomeResponse> = withContext(Dispatchers.IO) {
        try {
            val response = apiService.getHomeData()
            if (response.isSuccessful && response.body() != null) {
                Resource.Success(response.body()!!)
            } else {
                Resource.Error("Failed to load home data: ${response.message()}")
            }
        } catch (e: Exception) {
            Resource.Error("Network error: ${e.message ?: "Unknown error"}")
        }
    }
    
    /**
     * Get posts by category
     */
    suspend fun getPostsByCategory(category: String, page: Int = 1): Resource<CategoryResponse> = withContext(Dispatchers.IO) {
        try {
            val response = apiService.getPostsByCategory(category, page)
            if (response.isSuccessful && response.body() != null) {
                Resource.Success(response.body()!!)
            } else {
                Resource.Error("Failed to load category: ${response.message()}")
            }
        } catch (e: Exception) {
            Resource.Error("Network error: ${e.message ?: "Unknown error"}")
        }
    }
    
    /**
     * Get post details by ID
     */
    suspend fun getPostById(postId: Int): Resource<PostDetailResponse> = withContext(Dispatchers.IO) {
        try {
            val response = apiService.getPostById(postId)
            if (response.isSuccessful && response.body() != null) {
                Resource.Success(response.body()!!)
            } else {
                Resource.Error("Failed to load post: ${response.message()}")
            }
        } catch (e: Exception) {
            Resource.Error("Network error: ${e.message ?: "Unknown error"}")
        }
    }
    
    /**
     * Get videos
     */
    suspend fun getVideos(page: Int = 1): Resource<VideoResponse> = withContext(Dispatchers.IO) {
        try {
            val response = apiService.getVideos(page)
            if (response.isSuccessful && response.body() != null) {
                Resource.Success(response.body()!!)
            } else {
                Resource.Error("Failed to load videos: ${response.message()}")
            }
        } catch (e: Exception) {
            Resource.Error("Network error: ${e.message ?: "Unknown error"}")
        }
    }
    
    /**
     * Add a comment to a post
     */
    suspend fun addComment(postId: Int, author: String, content: String): Resource<CommentResponse> = withContext(Dispatchers.IO) {
        try {
            val response = apiService.addComment(postId, author, content)
            if (response.isSuccessful && response.body() != null) {
                Resource.Success(response.body()!!)
            } else {
                Resource.Error("Failed to add comment: ${response.message()}")
            }
        } catch (e: Exception) {
            Resource.Error("Network error: ${e.message ?: "Unknown error"}")
        }
    }
    
    /**
     * Rate a post (like or dislike)
     */
    suspend fun ratePost(postId: Int, isLike: Boolean): Resource<RatingResponse> = withContext(Dispatchers.IO) {
        try {
            val action = if (isLike) "like" else "dislike"
            val response = apiService.ratePost(postId, action)
            if (response.isSuccessful && response.body() != null) {
                Resource.Success(response.body()!!)
            } else {
                Resource.Error("Failed to rate post: ${response.message()}")
            }
        } catch (e: Exception) {
            Resource.Error("Network error: ${e.message ?: "Unknown error"}")
        }
    }
} 