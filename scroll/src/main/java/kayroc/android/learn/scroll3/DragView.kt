package kayroc.android.learn.scroll3

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup.MarginLayoutParams


/**
 * @author kayroc
 */
class DragView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = android.R.attr.editTextStyle
) : View(context, attributeSet, defStyleAttr) {

    private var lastRawX = 0
    private var lastRawY = 0
    private var lastX = 0
    private var lastY = 0

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event == null) {
            return false
        }
        scrollByViewCoordinate(event)
        // scrollByRawCoordinate(event)
        return super.onTouchEvent(event)
    }

    /** 按视图坐标系滑动 */
    private fun scrollByViewCoordinate(event: MotionEvent) {
        val x = event.x.toInt()
        val y = event.y.toInt()
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                // 记录触摸点坐标
                lastX = x
                lastY = y
            }
            MotionEvent.ACTION_MOVE -> {
                // 计算偏移量
                val offsetX = x - lastX
                val offsetY = y - lastY

                // // getLayoutParams() 需要根据View所在父布局的类型来设置不同的类型
                // val layoutParams = layoutParams as LinearLayout.LayoutParams
                // layoutParams.leftMargin = left + offsetX
                // layoutParams.topMargin = top + offsetY
                // setLayoutParams(layoutParams)

                // ViewGroup.MarginLayoutParams 不需要指定父布局类型，更方便
                val layoutParams = layoutParams as MarginLayoutParams
                layoutParams.leftMargin = left + offsetX
                layoutParams.topMargin = top + offsetY
                setLayoutParams(layoutParams)
            }
        }
    }

    /** 按Android系滑动 */
    private fun scrollByRawCoordinate(event: MotionEvent) {
        val rawX = event.rawX.toInt()
        val rawY = event.rawY.toInt()
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                // 记录触摸点坐标
                lastRawX = rawX
                lastRawY = rawY
            }
            MotionEvent.ACTION_MOVE -> {
                // 计算偏移量
                val offsetX = rawX - lastRawX
                val offsetY = rawY - lastRawY

                // // getLayoutParams() 需要根据View所在父布局的类型来设置不同的类型
                // val layoutParams = layoutParams as LinearLayout.LayoutParams
                // layoutParams.leftMargin = left + offsetX
                // layoutParams.topMargin = top + offsetY
                // setLayoutParams(layoutParams)

                // ViewGroup.MarginLayoutParams 不需要指定父布局类型，更方便
                val layoutParams = layoutParams as MarginLayoutParams
                layoutParams.leftMargin = left + offsetX
                layoutParams.topMargin = top + offsetY
                setLayoutParams(layoutParams)

                // 重新设置初始坐标
                lastRawX = rawX
                lastRawY = rawY
            }
        }
    }
}