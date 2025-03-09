package com.hepsihikaye.android.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hepsihikaye.android.HepsihikayeApp
import com.hepsihikaye.android.api.HomeResponse
import com.hepsihikaye.android.util.Resource
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    
    private val repository = HepsihikayeApp.repository
    
    private val _homeData = MutableLiveData<Resource<HomeResponse>>()
    val homeData: LiveData<Resource<HomeResponse>> = _homeData
    
    /**
     * Load home data from the API
     */
    fun loadHomeData() {
        _homeData.value = Resource.Loading()
        
        viewModelScope.launch {
            val result = repository.getHomeData()
            _homeData.value = result
        }
    }
} 