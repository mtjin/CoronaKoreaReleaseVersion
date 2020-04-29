package com.mtjin.coronakorea.data.city


import com.google.gson.annotations.SerializedName

data class Gangwon(
    @SerializedName("countryName")
    val countryName: String,
    @SerializedName("0death")
    val death: String,
    @SerializedName("0newCase")
    val newCase: String,
    @SerializedName("0newCcase")
    val newCcase: String,
    @SerializedName("0newFcase")
    val newFcase: String,
    @SerializedName("0percentage")
    val percentage: String,
    @SerializedName("0recovered")
    val recovered: String,
    @SerializedName("0totalCase")
    val totalCase: String
)