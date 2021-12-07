package kayroc.android.learn

import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * 补间动画
 *
 * @author kayroc
 */
class TweenAnimActivity : AppCompatActivity() {
    private val mIvAnim: ImageView by lazy { findViewById<ImageView>(R.id.iv_anim) }
    private val mTvTranslateXml: TextView by lazy { findViewById<TextView>(R.id.tv_translate_xml) }
    private val mTvRotateXml: TextView by lazy { findViewById<TextView>(R.id.tv_rotate_xml) }
    private val mTvScaleXml: TextView by lazy { findViewById<TextView>(R.id.tv_scale_xml) }
    private val mTvAlphaXml: TextView by lazy { findViewById<TextView>(R.id.tv_alpha_xml) }
    private val mTvTogetherXml: TextView by lazy { findViewById<TextView>(R.id.tv_together_xml) }
    private val mTvTranslateJava: TextView by lazy { findViewById<TextView>(R.id.tv_translate_java) }
    private val mTvRotateJava: TextView by lazy { findViewById<TextView>(R.id.tv_rotate_java) }
    private val mTvScaleJava: TextView by lazy { findViewById<TextView>(R.id.tv_scale_java) }
    private val mTvAlphaJava: TextView by lazy { findViewById<TextView>(R.id.tv_alpha_java) }
    private val mTvTogetherJava: TextView by lazy { findViewById<TextView>(R.id.tv_together_java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tween_anim)

        // 平移 xml
        mTvTranslateXml.setOnClickListener {
            val translateAnim = AnimationUtils.loadAnimation(applicationContext, R.anim.anim_view_translate)
            mIvAnim.startAnimation(translateAnim)
        }

        // 旋转 xml
        mTvRotateXml.setOnClickListener {
            val rotateAnim = AnimationUtils.loadAnimation(applicationContext, R.anim.anim_view_rotate)
            mIvAnim.startAnimation(rotateAnim)
        }

        // 缩放 xml
        mTvScaleXml.setOnClickListener {
            val scaleAnim = AnimationUtils.loadAnimation(applicationContext, R.anim.anim_view_scale)
            mIvAnim.startAnimation(scaleAnim)
        }

        // 透明 xml
        mTvAlphaXml.setOnClickListener {
            val alphaAnim = AnimationUtils.loadAnimation(applicationContext, R.anim.anim_view_alpha)
            mIvAnim.startAnimation(alphaAnim)
        }

        // 一起动 xml
        mTvTogetherXml.setOnClickListener {
            val togetherAnim = AnimationUtils.loadAnimation(applicationContext, R.anim.anim_view_together)
            mIvAnim.startAnimation(togetherAnim)
        }
    }

}