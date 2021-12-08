package kayroc.android.learn

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


/**
 * 属性动画
 * @author kayroc
 */
class PropertyAnimActivity : AppCompatActivity() {
    private val mIvAnim: ImageView by lazy { findViewById<ImageView>(R.id.iv_anim) }
    private val mTvXml: TextView by lazy { findViewById<TextView>(R.id.tv_xml) }
    private val mTvObject: TextView by lazy { findViewById<TextView>(R.id.tv_object) }
    private val mTvValue: TextView by lazy { findViewById<TextView>(R.id.tv_value) }
    private val mTvSet: TextView by lazy { findViewById<TextView>(R.id.tv_set) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_property_anim)

        // 属性动画 - xml
        mTvXml.setOnClickListener {
            // 加载 ValueAnimator 动画
            val animator = AnimatorInflater.loadAnimator(this, R.animator.property_animator_value) as ValueAnimator
            animator.addUpdateListener {
                val animatedValue = it.animatedValue as Float
                mIvAnim.translationX = animatedValue
            }
            // // 加载 objectAnimator 动画
            // val animator = AnimatorInflater.loadAnimator(this, R.animator.property_animator_object)

            // 加载 AnimatorSet 动画
            // val animator = AnimatorInflater.loadAnimator(this, R.animator.property_animator_set)

            // 设置目标视图
            animator.setTarget(mIvAnim)
            // 起动动画
            animator.start()
        }

        // ObjectAnimator
        mTvObject.setOnClickListener {
            // ObjectAnimator 提供了 ofInt、ofFloat、ofObject 等静态方法构造动画对象
            // 传入的参数：动画目标对象、属性字段、属性开始值、属性中间值、属性结束值

            // 平移
            // val animator: ObjectAnimator = ObjectAnimator.ofFloat(mIvAnim, "translationX", 0f, 100f)
            // 旋转
            // val animator = ObjectAnimator.ofFloat(mIvAnim, "rotation", 0f, 360f)
            // 缩放
            // val animator = ObjectAnimator.ofFloat(mIvAnim, "scaleX", 1f, 2f)
            // 透明
            val animator = ObjectAnimator.ofFloat(mIvAnim, "alpha", 1f, 0f)

            // 设置动画时间
            animator.duration = 2000
            // 设置重复次数
            animator.repeatCount = 1
            // 设置重复模式
            animator.repeatMode = ObjectAnimator.REVERSE
            // 起动动画
            animator.start()
        }

        // ValueAnimator
        mTvValue.setOnClickListener {
            // ValueAnimator 是 ObjectAnimator 的父类，它继承自 Animator
            // ValueAnimator 同样提供了 ofInt、ofFloat、ofObject 等静态方法构造动画对象
            // 传入的参数是 动画过程的开始值、中间值、结束值
            // 可以将ValueAnimator看着一个值变化器，即在给定的时间内将一个目标值从给定的开始值变化到给定的结束值
            // 使用ValueAnimator时通常需要添加一个动画更新的监听器，在监听器中能够获取到执行过程中的每一个动画值

            val animator: ValueAnimator = ValueAnimator.ofFloat(0f, 100f)
            // 设置动画时间
            animator.duration = 2000
            // 设置重复次数
            animator.repeatCount = 1
            // 设置重复模式
            animator.repeatMode = ObjectAnimator.REVERSE
            // 设置动画监听
            animator.addUpdateListener {
                // 动画更新过程中的动画值，可以根据动画值的变化来关联对象的属性，实现属性动画
                val animatedValue = it.animatedValue as Float
                // Log.d("ValueAnimator", "动画值：" + value);
                mIvAnim.translationX = animatedValue
            }
            animator.start()
        }

        // AnimatorSet
        mTvSet.setOnClickListener {
            // X轴缩放
            val scaleXAnimator = ObjectAnimator.ofFloat(mIvAnim, "scaleX", 1f, 0.5f)
            scaleXAnimator.duration = 2000
            // Y轴缩放
            val scaleYAnimator = ObjectAnimator.ofFloat(mIvAnim, "scaleY", 1f, 0.5f)
            scaleYAnimator.duration = 2000
            // X轴旋转
            val rotationXAnimator = ObjectAnimator.ofFloat(mIvAnim, "rotationX", 0f, 360f)
            rotationXAnimator.duration = 2000
            // Y轴旋转
            val rotationYAnimator = ObjectAnimator.ofFloat(mIvAnim, "rotationY", 0f, 360f)
            rotationYAnimator.duration = 2000

            // 构建AnimatorSet
            val animatorSet = AnimatorSet()

            // // 挨个执行
            // animatorSet.playSequentially(scaleXAnimator, scaleYAnimator, rotationXAnimator, rotationYAnimator)

            // // 一起执行
            // animatorSet.playTogether(scaleXAnimator, scaleYAnimator, rotationXAnimator, rotationYAnimator)

            animatorSet.play(scaleXAnimator) // 给定动画
                .with(scaleYAnimator)        // 与给定动画同时执行
                .before(rotationXAnimator)   // 在给定动画执行之前执行
                .after(rotationYAnimator)    // 在给定动画执行之后执行

            // 起动动画
            animatorSet.start()
        }
    }
}