package com.mtjin.coronakorea.data.city.source.remote

import com.mtjin.coronakorea.data.city.CityResponse

interface CityRemoteDataSource {
    fun getCity(
        success: (CityResponse) -> Unit,
        fail: (Throwable) -> Unit
    )
}