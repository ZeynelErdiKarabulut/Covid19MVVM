package com.zeynelerdi.covid19status.ui.world_stats

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zeynelerdi.covid19status.data.ResultData
import com.zeynelerdi.covid19status.model.WorldStats
import com.zeynelerdi.covid19status.repository.AppRepositoryImpl
import kotlinx.coroutines.launch
import javax.inject.Inject

class WorldStatsViewModel @Inject constructor(
    private val repositoryImpl: AppRepositoryImpl
) : ViewModel() {

    private var _resultWorldStats = MutableLiveData<WorldStats>()
    var resultWorldStats: LiveData<WorldStats> = _resultWorldStats

    private var _errorMessage = MutableLiveData<String>()
    var errorMessage: LiveData<String> = _errorMessage

    private var _showLoading = MutableLiveData<Boolean>()
    var showLoading: LiveData<Boolean> = _showLoading

    fun getWorldStats() {
        _showLoading.postValue(true)
        viewModelScope.launch {
            try {
                when (val response = repositoryImpl.worldWithStats()) {
                    is ResultData.Success -> {
                        _showLoading.postValue(false)
                        _resultWorldStats.postValue(response.data)
                    }
                    is ResultData.Error -> {
                        _showLoading.postValue(false)
                        _errorMessage.postValue(response.exception.toString())
                    }
                }
            } catch (e: Exception) {
                _showLoading.postValue(false)
                _errorMessage.postValue(e.message)
            }
        }
    }
}