package kayroc.android.learn

import android.app.Activity
import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.transition.*
import android.view.View
import android.view.Window
import androidx.appcompat.app.AppCompatActivity

/**
 * Material 转场动画效果
 *
 * @author kayroc
 */
class TransitionEffectActivity : AppCompatActivity() {


    companion object {

        const val MATERIAL_ANIM_TYPE_EXPLODE = 1
        const val MATERIAL_ANIM_TYPE_FADE = 2
        const val MATERIAL_ANIM_TYPE_SLIDE = 3
        const val MATERIAL_ANIM_TYPE_SHARED = 4

        const val EXTRA_ANIM_TYPE = "animType"

        fun openActivity(activity: Activity, animType: Int) {
            val intent = Intent(activity, TransitionEffectActivity::class.java)
            intent.putExtra(EXTRA_ANIM_TYPE, animType)
            activity.startActivity(
                intent, ActivityOptions.makeSceneTransitionAnimation(activity).toBundle()
            )
        }

        fun openActivity(
            activity: Activity,
            animType: Int,
            sharedElement: View,
            sharedElementName: String
        ) {
            val intent = Intent(activity, TransitionEffectActivity::class.java)
            intent.putExtra(EXTRA_ANIM_TYPE, animType)
            activity.startActivity(
                intent, ActivityOptions.makeSceneTransitionAnimation(activity, sharedElement, sharedElementName)
                    .toBundle()
            )
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 开启Material动画
        window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
        // window.requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)
        setContentView(R.layout.activity_transition_effect)

        initAnimation()
    }

    private fun initAnimation() {
        val animType = intent.getIntExtra(EXTRA_ANIM_TYPE, 0)
        if (animType != MATERIAL_ANIM_TYPE_SHARED) {
            val transition = when (animType) {
                // Explode 爆炸式效果
                MATERIAL_ANIM_TYPE_EXPLODE -> Explode()
                // Fade 淡入淡出
                MATERIAL_ANIM_TYPE_FADE -> Fade()
                // Slide 滑动式效果
                MATERIAL_ANIM_TYPE_SLIDE -> Slide()
                else -> Slide()
            }
            transition.duration = 1000

            // 当A跳转B时，B的进场动画
            window.enterTransition = transition
            // 当A跳转B时，A的退场动画
            window.exitTransition = transition
            // 当B返回A时，B的退场动画
            window.returnTransition = transition
            // 当B返回A时，A的进场动画
            window.reenterTransition = transition
        } else {
            // Shared 共享元素
            val transitionSet = TransitionSet()
            // changeBounds         为目标视图布局边界的变化添加动画效果
            // changeClipBounds     为目标视图裁剪边界的变化添加动画效果
            // changeTransform      为目标视图缩放和旋转方面的变化添加动画效果
            // changeImageTransform 为目标图片尺寸和缩放方面的变化添加动画效果
            transitionSet.addTransition(ChangeTransform())
            transitionSet.addTransition(ChangeBounds())
            transitionSet.addTarget("shared")
            transitionSet.duration = 1000
            window.sharedElementEnterTransition = transitionSet
            window.sharedElementExitTransition = transitionSet
            window.sharedElementReturnTransition = transitionSet
            window.sharedElementReenterTransition = transitionSet
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finishAfterTransition()
    }
}