package com.hepsihikaye.android.api

import com.hepsihikaye.android.model.Comment
import com.hepsihikaye.android.model.Post
import com.hepsihikaye.android.model.Video
import retrofit2.Response
import retrofit2.http.*

/**
 * Retrofit interface for API calls to the Hepsihikaye website
 */
interface ApiService {
    
    /**
     * Get homepage data including featured, recent, and popular posts
     */
    @GET("/api/home")
    suspend fun getHomeData(): Response<HomeResponse>
    
    /**
     * Get posts by category
     */
    @GET("/api/category/{category}")
    suspend fun getPostsByCategory(
        @Path("category") category: String,
        @Query("page") page: Int = 1
    ): Response<CategoryResponse>
    
    /**
     * Get a single post by ID with its comments
     */
    @GET("/api/post/{postId}")
    suspend fun getPostById(
        @Path("postId") postId: Int
    ): Response<PostDetailResponse>
    
    /**
     * Get videos
     */
    @GET("/api/videos")
    suspend fun getVideos(
        @Query("page") page: Int = 1
    ): Response<VideoResponse>
    
    /**
     * Add a comment to a post
     */
    @FormUrlEncoded
    @POST("/api/post/{postId}/comment")
    suspend fun addComment(
        @Path("postId") postId: Int,
        @Field("author") author: String,
        @Field("content") content: String
    ): Response<CommentResponse>
    
    /**
     * Rate a post (like or dislike)
     */
    @FormUrlEncoded
    @POST("/api/post/{postId}/rate/{action}")
    suspend fun ratePost(
        @Path("postId") postId: Int,
        @Path("action") action: String  // 'like' or 'dislike'
    ): Response<RatingResponse>
}

/**
 * Response data classes
 */
data class HomeResponse(
    val featured_posts: List<Post>,
    val recent_posts: List<Post>,
    val most_liked_posts: List<Post>,
    val category_highlights: Map<String, List<Post>>
)

data class CategoryResponse(
    val posts: List<Post>,
    val pagination: Pagination,
    val category: String,
    val category_display: String
)

data class PostDetailResponse(
    val post: Post,
    val comments: List<Comment>,
    val related_posts: List<Post>
)

data class VideoResponse(
    val videos: List<Video>,
    val pagination: Pagination
)

data class CommentResponse(
    val success: Boolean,
    val message: String,
    val comment: Comment?
)

data class RatingResponse(
    val success: Boolean,
    val message: String,
    val likes: Int,
    val dislikes: Int
)

data class Pagination(
    val page: Int,
    val pages: Int,
    val has_next: Boolean,
    val has_prev: Boolean
) 