package com.mapbox.navigation.navigator

import com.mapbox.geojson.Point
import java.util.*

data class FixLocation(var coordinate: Point, var time: Date, val speed: Float?, val bearing: Float?, val altitude: Float?, val accuracyHorizontal: Float?, val provider: String?)