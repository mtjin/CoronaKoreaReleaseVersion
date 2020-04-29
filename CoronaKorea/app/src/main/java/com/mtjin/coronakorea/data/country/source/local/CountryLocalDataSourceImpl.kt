package com.mtjin.coronakorea.data.country.source.local

import com.mtjin.coronakorea.data.country.CountryResponse

class CountryLocalDataSourceImpl(private val countryDao: CountryDao) : CountryLocalDataSource {
    override fun insertCountry(country: CountryResponse) {
        countryDao.insertCountry(country)
    }

    override fun getCountry(): CountryResponse? {
        return countryDao.getCountry()
    }

}