package kayroc.android.learn

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 帧动画
        val mBtnFrameAnim = findViewById<Button>(R.id.btn_frame_anim)
        mBtnFrameAnim.setOnClickListener {
            startActivity(Intent(this, FrameAnimActivity::class.java))
        }

        // 补间动画
        val mBtnTweenAnim = findViewById<Button>(R.id.btn_tween_anim)
        mBtnTweenAnim.setOnClickListener {
            startActivity(Intent(this, TweenAnimActivity::class.java))
        }
    }
}