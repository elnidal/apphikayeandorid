package com.hepsihikaye.android.ui.video

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.hepsihikaye.android.R

class VideosFragment : Fragment() {
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Placeholder implementation
        return inflater.inflate(R.layout.fragment_videos, container, false)
    }
} 