package kayroc.android.learn

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat


/**
 * 帧动画
 *
 * @author kayroc
 */
class FrameAnimActivity : AppCompatActivity() {

    private val mIv: ImageView by lazy { findViewById<ImageView>(R.id.iv) }
    private val mBtnStart: Button by lazy { findViewById<Button>(R.id.btn_start) }
    private val mBtnEnd: Button by lazy { findViewById<Button>(R.id.btn_end) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frame_anim)

        // xmlAnim()

        javaAnim()

    }

    /**
     * java 代码方式动画
     */
    private fun javaAnim() {
        val animationDrawable = AnimationDrawable()
        for (i in 1..11) {
            val id = resources.getIdentifier("g$i", "drawable", packageName)
            val drawable = ContextCompat.getDrawable(this, id)
            animationDrawable.addFrame(drawable!!, 100)
        }

        mIv.setImageDrawable(animationDrawable)

        // 开始
        mBtnStart.setOnClickListener {
            animationDrawable.start()
        }

        // 结束
        mBtnEnd.setOnClickListener {
            animationDrawable.stop()
        }
    }

    /**
     * xml 方式动画
     */
    private fun xmlAnim() {
        mIv.setImageResource(R.drawable.anim_list_frame)

        val animationDrawable = mIv.drawable as AnimationDrawable

        // 开始
        mBtnStart.setOnClickListener {
            animationDrawable.start()
        }

        // 结束
        mBtnEnd.setOnClickListener {
            animationDrawable.stop()
        }
    }
}