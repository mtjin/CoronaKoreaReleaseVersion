package com.mtjin.coronakorea.module

import com.mtjin.coronakorea.data.city.source.remote.CityRemoteDataSource
import com.mtjin.coronakorea.data.city.source.remote.CityRemoteDataSourceImpl
import com.mtjin.coronakorea.data.country.source.remote.CountryRemoteDataSource
import com.mtjin.coronakorea.data.country.source.remote.CountryRemoteDataSourceImpl
import org.koin.core.module.Module
import org.koin.dsl.module

val remoteModule: Module = module {
    single<CountryRemoteDataSource> { CountryRemoteDataSourceImpl(get()) }
    single<CityRemoteDataSource> { CityRemoteDataSourceImpl(get()) }
}