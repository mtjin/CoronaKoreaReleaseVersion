package com.mtjin.coronakorea.data.city.source.remote

import com.mtjin.coronakorea.api.ApiInterface
import com.mtjin.coronakorea.data.city.CityResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response

class CityRemoteDataSourceImpl(private val apiInterface: ApiInterface) : CityRemoteDataSource {
    override fun getCity(success: (CityResponse) -> Unit, fail: (Throwable) -> Unit) {
        val cityCall = apiInterface.getCityInfo()
        cityCall.enqueue(object : Callback<CityResponse> {
            override fun onFailure(call: Call<CityResponse>, t: Throwable) {
                fail(t)
            }

            override fun onResponse(call: Call<CityResponse>, response: Response<CityResponse>) {
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