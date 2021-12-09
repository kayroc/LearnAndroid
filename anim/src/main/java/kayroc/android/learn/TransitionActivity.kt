package kayroc.android.learn

import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

/**
 * Material 转场动画的使用
 *
 * @author kayroc
 */
class TransitionActivity : AppCompatActivity() {
    private val mBtnOverrideStart: Button by lazy { findViewById<Button>(R.id.btn_override_start) }
    private val mBtnOverrideEnd: Button by lazy { findViewById<Button>(R.id.btn_override_end) }
    private val mBtnMaterialExplode: Button by lazy { findViewById<Button>(R.id.btn_material_explode) }
    private val mBtnMaterialFade: Button by lazy { findViewById<Button>(R.id.btn_material_fade) }
    private val mBtnMaterialSlide: Button by lazy { findViewById<Button>(R.id.btn_material_slide) }
    private val mBtnMaterialShared: Button by lazy { findViewById<Button>(R.id.btn_material_shared) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 开启Material动画
        window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
        // window.requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)
        setContentView(R.layout.activity_transition)

        initListener()
    }

    private fun initListener() {
        // overridePendingTransition 起动
        mBtnOverrideStart.setOnClickListener {
            startActivity(Intent(this, TransitionActivity::class.java))
            overridePendingTransition(R.anim.activity_right_in, R.anim.activity_right_out)
        }

        // overridePendingTransition 销毁
        mBtnOverrideEnd.setOnClickListener {
            finish()
            overridePendingTransition(R.anim.activity_left_in, R.anim.activity_left_out)
        }

        // material Explode 爆炸式动画
        mBtnMaterialExplode.setOnClickListener {
            // val transition = Explode()
            // transition.duration = 3000
            // // 当A跳转B时，B的进场动画
            // window.enterTransition = transition
            // // 当A跳转B时，A的退场动画
            // window.exitTransition = transition
            // // 当B返回A时，B的退场动画
            // window.returnTransition = transition
            // // 当B返回A时，A的进场动画
            // window.reenterTransition = transition
            TransitionEffectActivity.openActivity(this, TransitionEffectActivity.MATERIAL_ANIM_TYPE_EXPLODE)
        }

        // material Fade 淡入淡出动画
        mBtnMaterialFade.setOnClickListener {
            // val transition = Fade()
            // transition.duration = 3000
            // // 当A跳转B时，B的进场动画
            // window.enterTransition = transition
            // // 当A跳转B时，A的退场动画
            // window.exitTransition = transition
            // // 当B返回A时，B的退场动画
            // window.returnTransition = transition
            // // 当B返回A时，A的进场动画
            // window.reenterTransition = transition
            TransitionEffectActivity.openActivity(this, TransitionEffectActivity.MATERIAL_ANIM_TYPE_FADE)
        }

        // material Slide 滑动式动画
        mBtnMaterialSlide.setOnClickListener {
            // val transition = Slide()
            // transition.duration = 3000
            // // 当A跳转B时，B的进场动画
            // window.enterTransition = transition
            // // 当A跳转B时，A的退场动画
            // window.exitTransition = transition
            // // 当B返回A时，B的退场动画
            // window.returnTransition = transition
            // // 当B返回A时，A的进场动画
            // window.reenterTransition = transition
            TransitionEffectActivity.openActivity(this, TransitionEffectActivity.MATERIAL_ANIM_TYPE_SLIDE)
        }

        // material Shared 共享元素动画
        mBtnMaterialShared.setOnClickListener {
            // val set = TransitionSet()
            // set.addTransition(Explode())
            // set.addTransition(Fade())
            // set.duration = 1000
            // // 当A跳转B时，B的进场动画
            // window.enterTransition = set
            // // 当A跳转B时，A的退场动画
            // window.exitTransition = set
            // // 当B返回A时，B的退场动画
            // window.returnTransition = set
            // // 当B返回A时，A的进场动画
            // window.reenterTransition = set

            TransitionEffectActivity.openActivity(this, TransitionEffectActivity.MATERIAL_ANIM_TYPE_SHARED, mBtnMaterialShared, "shared")
        }

    }
}