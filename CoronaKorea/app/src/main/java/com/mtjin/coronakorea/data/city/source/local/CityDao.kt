package com.mtjin.coronakorea.data.city.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mtjin.coronakorea.data.city.Korea

@Dao
interface CityDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertKorea(korea: Korea)

    @Query("SELECT * FROM korea LIMIT 1")
    fun getKorea(): Korea?
}