package com.mapbox.services.android.navigation.v5.offroute

import android.location.Location
import com.mapbox.navigation.navigator.NavigationStatus
import com.mapbox.navigation.navigator.RouteState
import com.mapbox.services.android.navigation.v5.navigation.MapboxNavigationOptions
import com.mapbox.services.android.navigation.v5.routeprogress.RouteProgress

class OffRouteDetector : OffRoute() {

    override fun isUserOffRoute(
        location: Location,
        routeProgress: RouteProgress,
        options: MapboxNavigationOptions
    ): Boolean {
        // No impl
        return false
    }

    fun isUserOffRouteWith(status: NavigationStatus): Boolean {
        return status.routeState == RouteState.OFFROUTE
    }
}
