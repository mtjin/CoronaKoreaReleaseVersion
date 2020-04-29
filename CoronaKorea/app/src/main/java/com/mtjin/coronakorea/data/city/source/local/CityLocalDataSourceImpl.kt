package com.mtjin.coronakorea.data.city.source.local

import com.mtjin.coronakorea.data.city.Korea

class CityLocalDataSourceImpl(private val cityDao: CityDao) : CityLocalDataSource {
    override fun insertKorea(korea: Korea) {
        cityDao.insertKorea(korea)
    }

    override fun getKorea(): Korea? = cityDao.getKorea()

}