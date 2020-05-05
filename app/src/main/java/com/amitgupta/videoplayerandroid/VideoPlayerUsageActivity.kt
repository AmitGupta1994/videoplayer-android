package com.amitgupta.videoplayerandroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.amitgupta.video_player_android_library.CustomPlayerListener
import com.amitgupta.video_player_android_library.PlayType
import com.amitgupta.video_player_android_library.Video
import kotlinx.android.synthetic.main.activity_video_player_usage.*

class VideoPlayerUsageActivity : AppCompatActivity(), CustomPlayerListener {
    val layoutResId = R.layout.activity_video_player_usage

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(layoutResId)

        custom_video_player.setupPlayer(this)
        custom_video_player.setVideoData(Video("Video", playType = PlayType.RECORDED))
        /**
         * Here, it checks whether player is open Portrait or Landscape. And acc. to that is sets the video,controller,statusbar
         */
        custom_video_player.maintainOrientation()
    }

    override fun onNextClick() {
        custom_video_player.setVideoData(
            Video(
                "Video",
                videoUrl = "https://bitdash-a.akamaihd.net/content/sintel/hls/playlist.m3u8",
                playType = PlayType.LIVE
            )
        )
    }

    override fun onPreviousClick() {
        custom_video_player.setVideoData(
            Video(
                "Video",
                videoUrl = "https://bitdash-a.akamaihd.net/content/MI201109210084_1/m3u8s/f08e80da-bf1d-4e3d-8899-f0f6155f6efa.m3u8",
                playType = PlayType.RECORDED
            )
        )
    }

    override fun onVideoFinish() {
    }

}
