package com.mtjin.coronakorea.data.country.source

import com.mtjin.coronakorea.data.country.CountryResponse

interface CountryRepository {
    fun getSearchCountry(
        success: (CountryResponse) -> Unit,
        fail: (Throwable) -> Unit
    )
}