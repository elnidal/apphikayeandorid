package com.hepsihikaye.android.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hepsihikaye.android.model.HomeResponse
import com.hepsihikaye.android.util.Resource
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    
    private val _homeData = MutableLiveData<Resource<HomeResponse>>()
    val homeData: LiveData<Resource<HomeResponse>> = _homeData
    
    fun loadHomeData() {
        _homeData.value = Resource.Loading()
        
        viewModelScope.launch {
            try {
                // TODO: Implement API call
                // For now, just show empty data
                _homeData.value = Resource.Success(HomeResponse(
                    featured_posts = emptyList(),
                    recent_posts = emptyList(),
                    most_liked_posts = emptyList()
                ))
            } catch (e: Exception) {
                _homeData.value = Resource.Error(
                    message = e.message ?: "An unexpected error occurred",
                    data = null
                )
            }
        }
    }
} 