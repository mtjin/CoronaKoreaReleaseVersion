package com.mtjin.coronakorea.data.city


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "korea")
data class Korea(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @SerializedName("countryName")
    val countryName: String,
    @SerializedName("death")
    val death: String,
    @SerializedName("newCase")
    val newCase: String,
    @SerializedName("newCcase")
    val newCcase: String,
    @SerializedName("newFcase")
    val newFcase: String,
    @SerializedName("percentage")
    val percentage: String,
    @SerializedName("recovered")
    val recovered: String,
    @SerializedName("totalCase")
    val totalCase: String
)