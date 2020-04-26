package com.amitgupta.video_player_android_library.utils

object TimeUtil {

    fun formatMillisToHH_MM(millisec: Int): String {
        var seconds = millisec / 1000
        val hours = seconds / (60 * 60)
        seconds %= 60 * 60
        val minutes = seconds / 60
        seconds %= 60

        val time: String
        if (hours > 0) {
            time = String.format("%d:%02d:%02d", hours, minutes, seconds)
        } else {
            time = String.format("%d:%02d", minutes, seconds)
        }
        return time
    }
}