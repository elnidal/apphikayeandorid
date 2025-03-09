package com.hepsihikaye.android.util

/**
 * App-wide constants
 */
object Constants {
    /**
     * Base URL for API calls
     */
    const val BASE_URL = "https://hepsihikaye.net"
    
    /**
     * Categories 
     */
    object Categories {
        const val STORY = "story"
        const val ARTICLE = "article"
        const val POEM = "poem"
        const val VIDEO = "video"
    }
    
    /**
     * Preferences 
     */
    object Prefs {
        const val PREF_FILE_NAME = "hepsihikaye_prefs"
        const val PREF_THEME = "app_theme"
        const val PREF_TEXT_SIZE = "text_size"
        const val PREF_USERNAME = "username"
    }
    
    /**
     * Intent extras
     */
    object Extras {
        const val EXTRA_POST_ID = "post_id"
        const val EXTRA_CATEGORY = "category"
        const val EXTRA_VIDEO_ID = "video_id"
    }
} 