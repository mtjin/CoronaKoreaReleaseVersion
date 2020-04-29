package com.mtjin.coronakorea.views.country

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mtjin.coronakorea.data.country.CountryResponse
import com.mtjin.coronakorea.data.country.source.CountryRepository

class CountryViewModel(private val countryRepository: CountryRepository) : ViewModel() {
    private val _isLoading = MutableLiveData<Boolean>(false)
    private val _countryResponse = MutableLiveData<CountryResponse>()
    private val _toastMsg = MutableLiveData<String>("")

    val isLoading: LiveData<Boolean> get() = _isLoading
    val countryResponse: LiveData<CountryResponse> get() = _countryResponse
    val toastMsg: LiveData<String> get() = _toastMsg

    fun requestCountry() {
        _isLoading.value = true
        countryRepository.getSearchCountry(
            success = {
                Log.d(TAG, ""+it)
                _countryResponse.value = it
                _isLoading.value = false
            },
            fail = {
                Log.d(TAG, ""+it)
                _isLoading.value = false
            }
        )
    }

    companion object{
        const val TAG = "CountryViewModelT"
    }
}