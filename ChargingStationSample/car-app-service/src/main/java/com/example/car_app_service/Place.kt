package com.example.car_app_service

/** Data class for individual charging station location information. */
data class Place(
    val id: Int,
    val name: String,
    val lat: Double,
    val long: Double
)

/** List of places data used to show charging station information. */
val PLACES = listOf(
    Place(
        id = 0,
        name = "EVgo Charging",
        lat = 37.37884615021511,
        long = -122.07565571815383
    ),
    Place(
        id = 1,
        name = "Electrify America Charging",
        lat = 37.404150750890935,
        long = -122.10920872055902
    ),
    Place(
        id = 2,
        name = "Tesla Supercharger",
        lat = 37.4176970033882,
        long = -122.07739089841327
    ),
)
