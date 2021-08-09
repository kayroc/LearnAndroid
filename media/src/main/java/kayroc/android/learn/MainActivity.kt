package kayroc.android.learn

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kayroc.android.learn.audio.AudioActivity
import kayroc.android.learn.camera.CameraActivity
import kayroc.android.learn.notification.NotificationActivity
import kayroc.android.learn.video.VideoActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 通知
        val mBtnNotice = findViewById<Button>(R.id.btn_notice)
        mBtnNotice.setOnClickListener {
            startActivity(Intent(this, NotificationActivity::class.java))
        }

        // 拍照
        val mBtnCamera = findViewById<Button>(R.id.btn_camera)
        mBtnCamera.setOnClickListener {
            startActivity(Intent(this, CameraActivity::class.java))
        }

        // 音频
        val mBtnAudio = findViewById<Button>(R.id.btn_audio)
        mBtnAudio.setOnClickListener {
            startActivity(Intent(this, AudioActivity::class.java))
        }

        // 视频
        val mBtnVideo = findViewById<Button>(R.id.btn_video)
        mBtnVideo.setOnClickListener {
            startActivity(Intent(this, VideoActivity::class.java))
        }
    }
}