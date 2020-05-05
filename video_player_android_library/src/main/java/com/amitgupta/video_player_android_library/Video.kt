package com.amitgupta.video_player_android_library

data class Video(
    var videoName: String = "",
    var videoUrl: String = "https://bitdash-a.akamaihd.net/content/sintel/hls/playlist.m3u8",    //May be online url or local Uri
//    var videoUrl: String = "http://video.wmspanel.com/local/raw/nimble.mp4",    //May be online url or local Uri
    var videoPlayedDuration: Long = 0, //Will contain the millis of played video
    var playType: PlayType
)
