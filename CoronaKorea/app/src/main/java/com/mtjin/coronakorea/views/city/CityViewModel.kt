package com.mtjin.coronakorea.views.city

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mtjin.coronakorea.data.city.CityResponse
import com.mtjin.coronakorea.data.city.source.CityRepository


class CityViewModel(private val cityRepository: CityRepository) : ViewModel() {
    private val _currentQuery = MutableLiveData<String>()
    private val _isLoading = MutableLiveData<Boolean>(false)
    private val _cityResponse = MutableLiveData<CityResponse>()

    val currentQuery: LiveData<String> get() = _currentQuery
    val isLoading: LiveData<Boolean> get() = _isLoading
    val cityResponse: LiveData<CityResponse> get() = _cityResponse

    fun requestCity(query: String) {
        _isLoading.value = true
        cityRepository.getSearchCity(
            success = {
                _cityResponse.value = it
                _isLoading.value = false
                _currentQuery.value = query
            },
            fail = {
                _isLoading.value = false
            }
        )
    }
}