package com.mtjin.coronakorea.data.country.source.remote

import com.mtjin.coronakorea.api.ApiInterface
import com.mtjin.coronakorea.data.country.CountryResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response

class CountryRemoteDataSourceImpl(private val apiInterface: ApiInterface) :
    CountryRemoteDataSource {
    override fun getCountry(success: (CountryResponse) -> Unit, fail: (Throwable) -> Unit) {
        val countryCall = apiInterface.getCountryInfo()
        countryCall.enqueue(object : Callback<CountryResponse> {
            override fun onFailure(call: Call<CountryResponse>, t: Throwable) {
                fail(t)
            }

            override fun onResponse(
                call: Call<CountryResponse>,
                response: Response<CountryResponse>
            ) {
                with(response) {
                    val body = body()
                    if (isSuccessful && body != null) {
                        success(body)
                    } else {
                        fail(HttpException(this))
                    }
                }
            }

        })
    }
}