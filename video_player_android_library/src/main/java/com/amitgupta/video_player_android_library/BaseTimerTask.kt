package com.amitgupta.video_player_android_library

import android.os.Handler
import java.util.*

abstract class BaseTimerTask : TimerTask() {

    private lateinit var timer: Timer
    private val handler = Handler()

    fun scheduleTask(baseTimerTask:BaseTimerTask, delay: Long, period: Long) {
        if (::timer.isInitialized)
            timer.cancel()
        timer = Timer()
        timer.schedule(baseTimerTask, delay, period)
    }

    fun runTask(task: () -> Unit) {
        handler.post {
            task()
        }
    }

    fun cancelTask() {
        if (::timer.isInitialized)
            timer.cancel()
    }
}
