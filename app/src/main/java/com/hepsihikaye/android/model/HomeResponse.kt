package com.hepsihikaye.android.model

data class HomeResponse(
    val featured_posts: List<Post>,
    val recent_posts: List<Post>,
    val most_liked_posts: List<Post>
) 