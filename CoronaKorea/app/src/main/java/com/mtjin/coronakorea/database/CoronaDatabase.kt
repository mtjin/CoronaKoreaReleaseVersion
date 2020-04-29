package com.mtjin.coronakorea.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mtjin.coronakorea.data.city.CityResponse
import com.mtjin.coronakorea.data.city.Korea
import com.mtjin.coronakorea.data.city.source.local.CityDao
import com.mtjin.coronakorea.data.country.CountryResponse
import com.mtjin.coronakorea.data.country.source.local.CountryDao


@Database(entities = [CountryResponse::class, Korea::class], version = 1, exportSchema = false)
abstract class CoronaDatabase : RoomDatabase() {
    abstract fun countryDao() : CountryDao
    abstract fun cityDao() : CityDao
}