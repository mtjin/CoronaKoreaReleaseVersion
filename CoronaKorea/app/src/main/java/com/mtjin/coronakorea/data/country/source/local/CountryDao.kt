package com.mtjin.coronakorea.data.country.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mtjin.coronakorea.data.country.CountryResponse

@Dao
interface CountryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCountry(country: CountryResponse)

    @Query("SELECT * FROM country LIMIT 1")
    fun getCountry(): CountryResponse?
}