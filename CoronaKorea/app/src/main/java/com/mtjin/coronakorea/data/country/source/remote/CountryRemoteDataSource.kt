package com.mtjin.coronakorea.data.country.source.remote

import com.mtjin.coronakorea.data.country.CountryResponse

interface CountryRemoteDataSource {
    fun getCountry(
        success: (CountryResponse) -> Unit,
        fail: (Throwable) -> Unit
    )
}