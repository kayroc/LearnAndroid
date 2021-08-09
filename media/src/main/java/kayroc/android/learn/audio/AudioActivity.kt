package kayroc.android.learn.audio

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kayroc.android.learn.R

/**
 * @author kayroc
 */
class AudioActivity : AppCompatActivity() {
    private val mBtnPlay: Button by lazy { findViewById<Button>(R.id.btn_play) }
    private val mBtnPause: Button by lazy { findViewById<Button>(R.id.btn_pause) }
    private val mBtnStop: Button by lazy { findViewById<Button>(R.id.btn_stop) }
    private val mediaPlayer = MediaPlayer()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_audio)

        initMediaPlayer()

        // 播放
        mBtnPlay.setOnClickListener {
            if (!mediaPlayer.isPlaying) {
                mediaPlayer.start()
            }
        }

        // 暂停
        mBtnPause.setOnClickListener {
            if (mediaPlayer.isPlaying) {
                mediaPlayer.pause()
            }
        }

        // 停止
        mBtnStop.setOnClickListener {
            if (mediaPlayer.isPlaying) {
                mediaPlayer.reset()
                initMediaPlayer()
            }
        }
    }

    private fun initMediaPlayer() {
        val assetManager = assets
        val fd = assetManager.openFd("music.mp3")
        mediaPlayer.setDataSource(fd.fileDescriptor, fd.startOffset, fd.length)
        mediaPlayer.prepare()
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.stop()
        mediaPlayer.release()
    }
}