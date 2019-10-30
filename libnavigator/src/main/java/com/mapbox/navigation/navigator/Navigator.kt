package com.mapbox.navigation.navigator

import com.mapbox.geojson.Point
import java.util.*

class Navigator {
    private var peer: Long = 0

    constructor(){
        initialize(this)
    }

    constructor(peer: Long){
        this.peer = peer
    }

    external fun setRoute(var1: String, var2: Int, var3: Int): NavigationStatus

    external fun updateAnnotations(var1: String, var2: Int, var3: Int): Boolean

    external fun updateLocation(var1: FixLocation): Boolean

    external fun getStatus(var1: Date): NavigationStatus

    external fun getBearing(): Float?

    external fun getBannerInstruction(): BannerInstruction?

    external fun getVoiceInstruction(): VoiceInstruction?

    external fun getBannerInstruction(var1: Int): BannerInstruction?

    external fun getVoiceInstruction(var1: Int): VoiceInstruction?

    external fun getRouteGeometry(): ArrayList<Point>?

    external fun getRouteBoundingBox(): ArrayList<Point>?

    external fun getRouteBufferGeoJson(var1: Float, var2: Short): String?

    external fun getHistory(): String

    external fun toggleHistory(var1: Boolean)

    external fun pushHistory(var1: String, var2: String)

    external fun changeRouteLeg(var1: Int, var2: Int): NavigationStatus

    external fun getConfig(): NavigatorConfig

    external fun setConfig(var1: NavigatorConfig?)

    external fun configureRouter(var1: String): Long

    external fun getRoute(var1: String): RouterResult

    external fun unpackTiles(var1: String, var2: String): Long

    external fun removeTiles(var1: String, var2: Point, var3: Point): Long

    external fun getTraceAttributes(var1: String): RouterResult

    private external fun initialize(p0: Navigator)

    @Throws(Throwable::class)
    protected external fun finalize()
}