package com.hepsihikaye.android.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.hepsihikaye.android.R

class SettingsFragment : Fragment() {
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Placeholder implementation
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }
} 