package kayroc.android.learn

import android.os.Bundle
import android.view.animation.*
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

        // 渐变 xml
        mTvAlphaXml.setOnClickListener {
            val alphaAnim = AnimationUtils.loadAnimation(applicationContext, R.anim.anim_view_alpha)
            mIvAnim.startAnimation(alphaAnim)
        }

        // 一起动 xml
        mTvTogetherXml.setOnClickListener {
            val togetherAnim = AnimationUtils.loadAnimation(applicationContext, R.anim.anim_view_together)
            mIvAnim.startAnimation(togetherAnim)
        }

        // 平移 Java
        mTvTranslateJava.setOnClickListener {
            val animation = TranslateAnimation(-100f, 100f, 0f, 0f)
            // val animation = TranslateAnimation(
            //     Animation.RELATIVE_TO_SELF, -50f,
            //     Animation.RELATIVE_TO_SELF, 50f,
            //     Animation.RELATIVE_TO_SELF, -10f,
            //     Animation.RELATIVE_TO_SELF, 0f)
            // 指定动画持续时间
            animation.duration = 2000
            // 设置重复次数
            animation.repeatCount = 1
            // 设置重复模式
            animation.repeatMode = Animation.REVERSE
            // 开始动画
            mIvAnim.startAnimation(animation)
        }

        // 旋转 Java
        mTvRotateJava.setOnClickListener {
            val animation = RotateAnimation(0f, 180f,
                mIvAnim.width / 2f, mIvAnim.height / 2f)
            // 指定动画持续时间
            animation.duration = 2000
            // 设置重复次数
            animation.repeatCount = 1
            // 设置重复模式
            animation.repeatMode = Animation.REVERSE
            // 开始动画
            mIvAnim.startAnimation(animation)
        }

        // 缩放 Java
        mTvScaleJava.setOnClickListener {
            val animation = ScaleAnimation(2f, 0.5f, 2f, 0.5f)
            // 指定动画持续时间
            animation.duration = 2000
            // 设置重复次数
            animation.repeatCount = 1
            // 设置重复模式
            animation.repeatMode = Animation.REVERSE
            // 开始动画
            mIvAnim.startAnimation(animation)
        }

        // 渐变 java
        mTvAlphaJava.setOnClickListener {
            val animation = AlphaAnimation(1f, 0f)
            // 指定动画持续时间
            animation.duration = 2000
            // 设置重复次数
            animation.repeatCount = 1
            // 设置重复模式
            animation.repeatMode = Animation.REVERSE
            // 开始动画
            mIvAnim.startAnimation(animation)
        }

        // 一起动 Java
        mTvTogetherJava.setOnClickListener {
            // 1.创建动画集合
            val animationSet = AnimationSet(false)
            animationSet.duration = 2000

            // 2.向集合中添加动画

            // 位移动画
            val ta = TranslateAnimation(-100f, 100f, 0f, 0f)
            // ta.duration = 2000
            animationSet.addAnimation(ta)
            // 缩放动画
            val sa = ScaleAnimation(2f, 0.5f, 2f, 0.5f)
            // sa.duration = 2000
            animationSet.addAnimation(sa)
            // 旋转动画
            val ra = RotateAnimation(0f, 180f,
                mIvAnim.width / 2f, mIvAnim.height / 2f)
            // ra.duration = 2000
            animationSet.addAnimation(ra)
            // 渐变动画
            val aa = AlphaAnimation(1f, 0f)
            // aa.duration = 2000
            animationSet.addAnimation(aa)

            mIvAnim.startAnimation(animationSet)
        }
    }

}