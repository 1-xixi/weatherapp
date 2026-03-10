package com.example.weather
import com.google.gson.annotations.SerializedName

data class Weather(
    @SerializedName("wea")
    val wea: String,
    @SerializedName("date")
    val date: String,
    @SerializedName("tem")
    val tem: String,
    @SerializedName("win_speed")
    val winSpeed: String,
)

