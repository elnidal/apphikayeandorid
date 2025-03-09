package com.hepsihikaye.android

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp

/**
 * Main application class that initializes everything on app start
 */
@HiltAndroidApp
class HepsihikayeApp : Application() {
    
    companion object {
        private const val TAG = "HepsihikayeApp"
        
        // Lazy initialized repository
        val repository by lazy { createRepository() }
        
        private fun createRepository(): com.hepsihikaye.android.api.Repository {
            return com.hepsihikaye.android.api.Repository()
        }
    }
    
    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "Application initialized")
        
        // Initialize any libraries or components that need application context here
    }
} 