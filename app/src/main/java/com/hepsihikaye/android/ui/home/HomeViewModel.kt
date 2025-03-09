package com.hepsihikaye.android.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hepsihikaye.android.model.HomeResponse
import com.hepsihikaye.android.repository.HomeRepository
import com.hepsihikaye.android.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: HomeRepository
) : ViewModel() {
    
    private val _homeData = MutableLiveData<Resource<HomeResponse>>()
    val homeData: LiveData<Resource<HomeResponse>> = _homeData
    
    init {
        loadHomeData()
    }
    
    fun loadHomeData() {
        _homeData.value = Resource.Loading()
        
        viewModelScope.launch {
            val result = repository.getHomeData()
            _homeData.value = result
        }
    }
} 