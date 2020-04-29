package com.mtjin.coronakorea.data.country.source

import com.mtjin.coronakorea.data.country.CountryResponse
import com.mtjin.coronakorea.data.country.source.local.CountryLocalDataSource
import com.mtjin.coronakorea.data.country.source.remote.CountryRemoteDataSource
import com.mtjin.coronakorea.utils.NetworkManager

class CountryRepositoryImpl(
    private val countryRemoteDataSource: CountryRemoteDataSource,
    private val countryLocalDataSource: CountryLocalDataSource,
    private val networkManager: NetworkManager
) : CountryRepository {
    override fun getSearchCountry(success: (CountryResponse) -> Unit, fail: (Throwable) -> Unit) {

        if (networkManager.checkNetworkState()) {
            //캐싱은 애니메이션 효과때문에 없는게 나은듯
            //remote
            countryRemoteDataSource.getCountry(
                success = {
                    countryLocalDataSource.insertCountry(it)
                    success(it)
                },
                fail = {
                    fail(Throwable())
                }
            )
        } else {
            //local
            countryLocalDataSource.getCountry()?.let { success(it) }
        }
    }

}