package com.mtjin.coronakorea.module

import androidx.room.Room
import com.mtjin.coronakorea.data.city.source.local.CityDao
import com.mtjin.coronakorea.data.city.source.local.CityLocalDataSource
import com.mtjin.coronakorea.data.city.source.local.CityLocalDataSourceImpl
import com.mtjin.coronakorea.data.country.source.local.CountryDao
import com.mtjin.coronakorea.data.country.source.local.CountryLocalDataSource
import com.mtjin.coronakorea.data.country.source.local.CountryLocalDataSourceImpl
import com.mtjin.coronakorea.database.CoronaDatabase
import org.koin.core.module.Module
import org.koin.dsl.module

val localDataModule: Module = module {
    single<CountryLocalDataSource> { CountryLocalDataSourceImpl(get()) }
    single<CityLocalDataSource> { CityLocalDataSourceImpl(get()) }
    single<CountryDao> { get<CoronaDatabase>().countryDao() }
    single<CityDao> { get<CoronaDatabase>().cityDao() }
    single<CoronaDatabase> {
        Room.databaseBuilder(
            get(),
            CoronaDatabase::class.java, "Corona.db"
        )
            .allowMainThreadQueries()
            .build()
    }

}