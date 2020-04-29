package com.mtjin.coronakorea.api

import com.mtjin.coronakorea.data.city.CityResponse
import com.mtjin.coronakorea.data.country.CountryResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("korea/country/new/")
    fun getCityInfo(
        @Query("serviceKey") serviceKey: String = "3808684a386e1a1b7e0e5faf9c5a4a223"
    ): Call<CityResponse>

    @GET("korea/")
    fun getCountryInfo(
        @Query("serviceKey") serviceKey: String = "3808684a386e1a1b7e0e5faf9c5a4a223"
    ): Call<CountryResponse>
}