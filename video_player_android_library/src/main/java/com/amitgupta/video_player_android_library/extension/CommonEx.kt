package com.amitgupta.video_player_android_library.extension

import android.app.Activity
import android.content.Context
import android.content.pm.ActivityInfo
import android.view.WindowManager
import com.amitgupta.video_player_android_library.BuildConfig

val debug = BuildConfig.DEBUG //false
const val testDevice = true
val debugTest = debug && testDevice

/**
 * Hide/Show StatusBar
 */
fun Context.showOrHideStatusBar(show: Boolean = true) {
    if (show) {
        (this as Activity).window.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)

    } else {
        (this as Activity).window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)

    }
}

/**
 * Set Orientation to Landscape/Portrait
 */
fun Context.changeScreenOrientation(portrait: Boolean = true) {
    if (portrait) {
        (this as Activity).requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT
    } else {
        (this as Activity).requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE
    }
}