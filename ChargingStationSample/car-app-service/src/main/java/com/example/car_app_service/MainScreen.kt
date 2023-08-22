package com.example.car_app_service

import android.text.Spannable
import android.text.SpannableString
import androidx.car.app.CarContext
import androidx.car.app.Screen
import androidx.car.app.model.CarLocation
import androidx.car.app.model.Distance
import androidx.car.app.model.DistanceSpan
import androidx.car.app.model.ItemList
import androidx.car.app.model.PlaceListMapTemplate
import androidx.car.app.model.Row
import androidx.car.app.model.Template
import androidx.car.app.model.Metadata
import androidx.car.app.model.PlaceMarker

class MainScreen(carContext: CarContext) : Screen(carContext) {
    override fun onGetTemplate(): Template {
        val placesRow = PLACES.map { getPlaceRow(it) }
        val itemListBuilder = ItemList.Builder().apply {
            placesRow.forEach { row -> addItem(row) }
        }

        return PlaceListMapTemplate.Builder()
            .setTitle("Mountain View area")
            .setItemList(itemListBuilder.build())
            .build()
    }

    private fun getPlaceRow(place: Place): Row {
        return Row.Builder()
            .setTitle(place.name)
            .addText(SpannableString(" ").apply {
                setSpan(
                    DistanceSpan.create(
                        Distance.create(Math.random() * 100, Distance.UNIT_KILOMETERS)
                    ), 0, 1, Spannable.SPAN_INCLUSIVE_INCLUSIVE
                )
            })
            // Setting Metadata is required to show the item's location on the provided map.
            .setMetadata(getMetadata(place)).build()
    }

    private fun getMetadata(place: Place): Metadata {
        return Metadata.Builder()
            .setPlace(
                androidx.car.app.model.Place.Builder(
                    CarLocation.create(
                        place.lat,
                        place.long
                    )
                )
                    .setMarker(PlaceMarker.Builder().build())
                    .build()
            )
            .build()
    }
}
