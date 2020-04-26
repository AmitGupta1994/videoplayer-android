package com.amitgupta.video_player_android_library

data class Video(
    var videoName: String = "",
//    var videoUrl: String = "http://www.streambox.fr/playlists/test_001/stream.m3u8",    //May be online url or local Uri
    var videoUrl: String = "http://content.jwplatform.com/manifests/vM7nH0Kl.m3u8",    //May be online url or local Uri
    var videoPlayedDuration: Long = 0, //Will contain the millis of played video
    var playType: PlayType
)