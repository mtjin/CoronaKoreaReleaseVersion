package com.mtjin.coronakorea.data.country.source.local

import com.mtjin.coronakorea.data.country.CountryResponse

interface CountryLocalDataSource {
    fun insertCountry(country: CountryResponse)
    fun getCountry(): CountryResponse?
}