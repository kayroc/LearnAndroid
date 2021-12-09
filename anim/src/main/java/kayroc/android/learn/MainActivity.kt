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

        // 属性动画
        val mBtnPropertyAnim = findViewById<Button>(R.id.btn_property_anim)
        mBtnPropertyAnim.setOnClickListener {
            startActivity(Intent(this, PropertyAnimActivity::class.java))
        }

        // 涟漪动画(水波纹)
        val mBtnRippleEffect = findViewById<Button>(R.id.btn_ripple_effect)
        mBtnRippleEffect.setOnClickListener {
            startActivity(Intent(this, RippleEffectActivity::class.java))
        }

        // 揭露动画
        val mBtnRevealEffect = findViewById<Button>(R.id.btn_reveal_effect)
        mBtnRevealEffect.setOnClickListener {
            startActivity(Intent(this, RevealEffectActivity::class.java))
        }

        // 转场动画 & 共享元素
        val mBtnTransition = findViewById<Button>(R.id.btn_transition)
        mBtnTransition.setOnClickListener {
            startActivity(Intent(this, TransitionActivity::class.java))
        }

        // 视图状态动画
        val mBtnViewState = findViewById<Button>(R.id.btn_view_state)
        mBtnViewState.setOnClickListener {
            startActivity(Intent(this, ViewStateActivity::class.java))
        }

        // 矢量图动画
        val mBtnVector = findViewById<Button>(R.id.btn_vector)
        mBtnVector.setOnClickListener {
            startActivity(Intent(this, VectorActivity::class.java))
        }
    }
}