package kayroc.android.learn

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.os.Bundle
import android.view.View
import android.view.ViewAnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlin.math.hypot

/**
 * 揭露动画
 *
 * @author kayroc
 */
class RevealEffectActivity : AppCompatActivity() {

    private val mView: View by lazy { findViewById<View>(R.id.view) }
    private val mFab: FloatingActionButton by lazy { findViewById<FloatingActionButton>(R.id.fab) }
    private var isShow = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reveal_effect)

        mFab.setOnClickListener {
            val vLocation = IntArray(2)
            mFab.getLocationInWindow(vLocation)
            val centerX: Int = vLocation[0] + mFab.measuredWidth / 2
            val centerY: Int = vLocation[1] + mFab.measuredHeight / 2

            val height: Int = mView.height
            val width: Int = mView.width
            val maxRadius = hypot(height.toDouble(), width.toDouble()).toFloat()

            isShow = !isShow
            if (isShow) {
                doRevealAnimation(mView, centerX, centerY, 0f, maxRadius)
            } else {
                doRevealAnimation(mView, centerX, centerY, maxRadius, 0f)
            }
        }
    }

    /**
     * 执行揭露动画
     *
     * @param view View? 执行揭露动画的 View 视图
     * @param centerX Int 相对于视图 View 的坐标系，动画圆的中心的x坐标
     * @param centerY Int 相对于视图 View 的坐标系，动画圆的中心的y坐标
     * @param startRadius Float 动画圆的起始半径
     * @param endRadius Float 动画圆的结束半径
     */
    fun doRevealAnimation(
        view: View?,
        centerX: Int, centerY: Int, startRadius: Float, endRadius: Float
    ) {
        val animator = ViewAnimationUtils.createCircularReveal(view, centerX, centerY, startRadius, endRadius)
        animator.duration = 1000
        animator.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationStart(animation: Animator?) {
                super.onAnimationStart(animation)
                if (isShow) {
                    mView.visibility = View.VISIBLE
                }
            }

            override fun onAnimationEnd(animation: Animator?) {
                super.onAnimationEnd(animation)
                if (!isShow) {
                    mView.visibility = View.INVISIBLE
                }
            }
        })
        animator.start()
    }
}