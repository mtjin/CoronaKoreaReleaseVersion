package com.mtjin.coronakorea.data.city.source

import com.mtjin.coronakorea.data.city.CityResponse

interface CityRepository {
    fun getSearchCity(
        success: (CityResponse) -> Unit,
        fail: (Throwable) -> Unit
    )
}