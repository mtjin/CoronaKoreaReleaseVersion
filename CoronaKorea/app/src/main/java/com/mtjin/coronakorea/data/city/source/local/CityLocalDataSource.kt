package com.mtjin.coronakorea.data.city.source.local

import com.mtjin.coronakorea.data.city.Korea

interface CityLocalDataSource {
    fun insertKorea(korea: Korea)
    fun getKorea(): Korea?
}