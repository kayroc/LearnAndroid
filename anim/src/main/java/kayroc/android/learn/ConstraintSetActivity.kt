package kayroc.android.learn

import android.os.Bundle
import android.transition.TransitionManager
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.constraintlayout.solver.widgets.ConstraintWidget
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet


/**
 * 约束布局实现的关键帧动画(ConstraintSet动画)
 *
 * ConstraintLayout动画|动态Constraint|用Java实现的UI
 * https://github.com/OCNYang/Android-Animation-Set/tree/master/constraint-animation
 *
 * @author kayroc
 */
class ConstraintSetActivity : AppCompatActivity() {
    private val mConstraintLayout: ConstraintLayout by lazy { findViewById(R.id.constraintLayout) }
    private val mBtn1: AppCompatButton by lazy { findViewById<AppCompatButton>(R.id.btn1) }
    private val mBtn2: AppCompatButton by lazy { findViewById<AppCompatButton>(R.id.btn2) }
    private val mBtn3: AppCompatButton by lazy { findViewById<AppCompatButton>(R.id.btn3) }
    private val mApply: AppCompatButton by lazy { findViewById<AppCompatButton>(R.id.apply) }
    private val mReset: AppCompatButton by lazy { findViewById<AppCompatButton>(R.id.reset) }

    private val applyConstraintSet = ConstraintSet()
    private val resetConstraintSet = ConstraintSet()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constraint_set)

        applyConstraintSet.clone(mConstraintLayout)
        resetConstraintSet.clone(mConstraintLayout)
    }

    // reset 按钮点击事件
    fun onResetClick(view: View) {
        // 重置约束
        resetConstraintSet.applyTo(mConstraintLayout)
    }

    // apply 按钮点击事件
    fun onApplyClick(view: View) {
        // apply1()
        // apply2()
        // apply3()
        // apply4()
        // apply5()
        apply6()
    }

    /**
     * 新需求6：
     *
     * 用户语言：
     *   当用户点击 apply按钮 的时候，我想要让所有的按钮都与屏幕的顶端对齐水平排列并且居中
     * 开发者语言：
     *   当用户点击 apply按钮 的时候，我想要通过在 ConstraintLayout 里使用 Java 代码来实现这三个按钮的 packed chaining 逻辑。你能帮我一下么？
     */
    private fun apply6() {
        TransitionManager.beginDelayedTransition(mConstraintLayout);

        applyConstraintSet.clear(R.id.btn1);
        applyConstraintSet.clear(R.id.btn2);
        applyConstraintSet.clear(R.id.btn3);

        // btn 1 left and top align to parent
        applyConstraintSet.connect(R.id.btn1, ConstraintSet.LEFT, R.id.constraintLayout, ConstraintSet.LEFT, 0)

        // btn 3 right and top align to parent
        applyConstraintSet.connect(R.id.btn3, ConstraintSet.RIGHT, R.id.constraintLayout, ConstraintSet.RIGHT, 0)

        // bi-direction or Chaining between btn 1 and btn 2
        applyConstraintSet.connect(R.id.btn2, ConstraintSet.LEFT, R.id.btn1, ConstraintSet.RIGHT, 0)
        applyConstraintSet.connect(R.id.btn1, ConstraintSet.RIGHT, R.id.btn2, ConstraintSet.LEFT, 0)

        // bi-direction or Chaining between btn 2 and btn 3
        applyConstraintSet.connect(R.id.btn2, ConstraintSet.RIGHT, R.id.btn3, ConstraintSet.LEFT, 0)
        applyConstraintSet.connect(R.id.btn3, ConstraintSet.LEFT, R.id.btn2, ConstraintSet.RIGHT, 0)

        applyConstraintSet.createHorizontalChain(R.id.constraintLayout, ConstraintSet.LEFT,
            R.id.constraintLayout, ConstraintSet.RIGHT,
            intArrayOf(R.id.btn1, R.id.btn3), null, ConstraintWidget.CHAIN_PACKED);

        applyConstraintSet.constrainWidth(R.id.btn1, ConstraintSet.WRAP_CONTENT)
        applyConstraintSet.constrainWidth(R.id.btn2, ConstraintSet.WRAP_CONTENT)
        applyConstraintSet.constrainWidth(R.id.btn3, ConstraintSet.WRAP_CONTENT)

        applyConstraintSet.constrainHeight(R.id.btn1, ConstraintSet.WRAP_CONTENT)
        applyConstraintSet.constrainHeight(R.id.btn2, ConstraintSet.WRAP_CONTENT)
        applyConstraintSet.constrainHeight(R.id.btn3, ConstraintSet.WRAP_CONTENT)

        applyConstraintSet.applyTo(mConstraintLayout)
    }

    /**
     * 新需求5：
     *
     * 用户语言：
     *   当用户点击 apply按钮 的时候，我想要让 按钮1 的宽度和高度充满整个屏幕并且让 按钮2、按钮3 隐藏。
     * 开发者语言：
     *   当用户点击 apply按钮 的时候，我想要通过在 ConstraintLayout 里使用 Java 代码让 按钮1 的宽度和高度都 match_parent，并且让 按钮2、按钮3 gone，你能帮我一下么？
     */
    private fun apply5() {
        TransitionManager.beginDelayedTransition(mConstraintLayout)

        applyConstraintSet.setVisibility(R.id.btn2, ConstraintSet.GONE)
        applyConstraintSet.setVisibility(R.id.btn3, ConstraintSet.GONE)

        applyConstraintSet.clear(R.id.btn1)
        applyConstraintSet.connect(R.id.btn1, ConstraintSet.LEFT, R.id.constraintLayout, ConstraintSet.LEFT, 0)
        applyConstraintSet.connect(R.id.btn1, ConstraintSet.RIGHT, R.id.constraintLayout, ConstraintSet.RIGHT, 0)
        applyConstraintSet.connect(R.id.btn1, ConstraintSet.TOP, R.id.constraintLayout, ConstraintSet.TOP, 0)
        applyConstraintSet.connect(R.id.btn1, ConstraintSet.BOTTOM, R.id.constraintLayout, ConstraintSet.BOTTOM, 0)

        applyConstraintSet.applyTo(mConstraintLayout)
    }

    /**
     * 新需求4：
     *
     * 用户语言：
     *   当用户点击 apply按钮 的时候，我想要让所有的按钮的宽度都变化成 400 像素
     * 开发者语言
     *   当用户点击 apply按钮 的时候，我想要通过在 constraint layout 里使用 Java 代码让所有按钮的宽度尺寸都变成 400 像素。你能帮我一下么？
     */
    private fun apply4() {
        TransitionManager.beginDelayedTransition(mConstraintLayout)

        applyConstraintSet.constrainWidth(R.id.btn1, 400)
        applyConstraintSet.constrainWidth(R.id.btn2, 400)
        applyConstraintSet.constrainWidth(R.id.btn3, 400)

        // applyConstraintSet.constrainHeight(R.id.btn1,100)
        // applyConstraintSet.constrainHeight(R.id.btn2,100)
        // applyConstraintSet.constrainHeight(R.id.btn3,100)

        applyConstraintSet.applyTo(mConstraintLayout)

    }

    /**
     * 新需求3：
     *
     * 用户语言：
     *   当用户点击 apply按钮 的时候，我想让 按钮3 动起来，然后移动到正中心。
     * 开发者语言：
     *   当用户点击 apply按钮 的时候，我想要通过在 ConstraintLayout 里使用 Java 代码让 按钮3 移动到父控件的中心。你能帮我一下么？
     */
    private fun apply3() {
        TransitionManager.beginDelayedTransition(mConstraintLayout)

        applyConstraintSet.setMargin(R.id.btn3, ConstraintSet.START, 0)
        applyConstraintSet.setMargin(R.id.btn3, ConstraintSet.END, 0)
        applyConstraintSet.setMargin(R.id.btn3, ConstraintSet.TOP, 0)
        applyConstraintSet.setMargin(R.id.btn3, ConstraintSet.BOTTOM, 0)

        applyConstraintSet.centerHorizontally(R.id.btn3, R.id.constraintLayout)
        applyConstraintSet.centerVertically(R.id.btn3, R.id.constraintLayout)

        applyConstraintSet.applyTo(mConstraintLayout)
    }

    /**
     * 新需求2：
     *
     * 用户语言：
     *   当用户点击 apply按钮 的时候，我想要让所有的按钮动起来并在父容器里水平居中。
     * 开发者语言：
     *   兄弟我想要当用户点击  apply按钮 的时候，通过使用 Java 代码让所有的按钮在 ConstraintLayout 里移动到水平居中的位置。你能帮我一下么？
     */
    private fun apply2() {
        TransitionManager.beginDelayedTransition(mConstraintLayout)

        applyConstraintSet.setMargin(R.id.btn1, ConstraintSet.START, 0)
        applyConstraintSet.setMargin(R.id.btn1, ConstraintSet.END, 0)
        applyConstraintSet.setMargin(R.id.btn2, ConstraintSet.START, 0)
        applyConstraintSet.setMargin(R.id.btn2, ConstraintSet.END, 0)
        applyConstraintSet.setMargin(R.id.btn3, ConstraintSet.START, 0)
        applyConstraintSet.setMargin(R.id.btn3, ConstraintSet.END, 0)

        applyConstraintSet.centerHorizontally(R.id.btn1, R.id.constraintLayout)
        applyConstraintSet.centerHorizontally(R.id.btn2, R.id.constraintLayout)
        applyConstraintSet.centerHorizontally(R.id.btn3, R.id.constraintLayout)
        applyConstraintSet.applyTo(mConstraintLayout)
    }

    /**
     * 新需求1：
     *
     * 用户语言：
     *   我想要让 按钮1 动起来，当用户点击 apply按钮 的时候，让它与父控件的左边对齐。你能帮我一下么？
     * 开发者语言：
     *   兄弟，我想要在 ConstraintLayout 里使用 Java 代码让 按钮1 在用户点击 apply按钮 的时候与父控件的左边对齐。你可以帮我一下么。
     */
    private fun apply1() {
        TransitionManager.beginDelayedTransition(mConstraintLayout)
        applyConstraintSet.setMargin(R.id.btn1, ConstraintSet.START, 0)
        applyConstraintSet.setMargin(R.id.btn1, ConstraintSet.LEFT, 0)
        applyConstraintSet.applyTo(mConstraintLayout)
    }
}