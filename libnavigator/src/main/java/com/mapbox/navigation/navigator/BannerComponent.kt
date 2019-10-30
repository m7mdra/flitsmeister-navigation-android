package com.mapbox.navigation.navigator

import java.util.ArrayList

data class BannerComponent(val type: String, val text: String, val abbr: String?, val abbrPriority: Int?, val imageBaseurl: String?, val active: Boolean?, val directions: ArrayList<String>?)