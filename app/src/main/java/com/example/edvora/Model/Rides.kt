package com.example.edvora.Model

import com.google.gson.annotations.SerializedName

data class Rides(
    val city: String,
    val date: String,
    val destinationStationCode: Int,
    val id: Int,
    @SerializedName("map_url")
    val mapUrl: String,
    @SerializedName("origin_station_code")
    val originStationCode: Int,
    val state: String,
    @SerializedName("station_path")
    val stationPath:List<Int>
)