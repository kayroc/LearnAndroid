package kayroc.android.learn.video

import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import kayroc.android.learn.R

/**
 * @author kayroc
 */
class VideoActivity : AppCompatActivity() {
    private val mBtnPlay: Button by lazy { findViewById<Button>(R.id.btn_play) }
    private val mBtnPause: Button by lazy { findViewById<Button>(R.id.btn_pause) }
    private val mBtnResume: Button by lazy { findViewById<Button>(R.id.btn_resume) }
    private val mVideoView: VideoView by lazy { findViewById<VideoView>(R.id.video_view) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)

        val uri = Uri.parse("android.resource://$packageName/${R.raw.video}")
        mVideoView.setVideoURI(uri)

        // 播放
        mBtnPlay.setOnClickListener {
            if (!mVideoView.isPlaying) {
                mVideoView.start() // 开始播放
            }
        }

        // 暂停
        mBtnPause.setOnClickListener {
            if (mVideoView.isPlaying) {
                mVideoView.pause() // 暂停播放
            }
        }

        // 重新播放
        mBtnResume.setOnClickListener {
            if (mVideoView.isPlaying) {
                mVideoView.resume() // 重新播放
            }
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        mVideoView.suspend()
    }
}