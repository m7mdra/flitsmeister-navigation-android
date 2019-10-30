package com.mapbox.navigation.navigator

data class VoiceInstructions(val ssmlAnnouncement: String, val announcement: String, val remainingStepDistance: Float, val index: Int)