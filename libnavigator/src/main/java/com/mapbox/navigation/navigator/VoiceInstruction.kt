package com.mapbox.navigation.navigator

data class VoiceInstruction(val ssmlAnnouncement: String, val announcement: String, val remainingStepDistance: Float, val index: Int)