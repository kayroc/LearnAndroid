package kayroc.android.learn.scroll4

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

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
        // scrollByViewCoordinate(event)
        scrollByRawCoordinate(event)
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

                // scrollTo() 表示移动到一个具体的坐标点(x, y)
                // scrollBy() 表示移动的增量为dx、dy

                // // 直接调用，看不到移动效果，因为移动的是 View 的 content。
                // // ViewGroup 的 content 是所有子View
                // // TextView 的 content 是它的文本
                // // ImageView 的 content 是它的 drawable 对象
                // scrollBy(offsetX, offsetY)
                // scrollTo(offsetX, offsetY)

                // 偏移量需要使用负数，才能看到移动效果
                // (parent as View).scrollBy(-offsetX, -offsetY)
                (parent as View).scrollTo((parent as View).scrollX - offsetX, (parent as View).scrollY - offsetY)

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

                // scrollTo() 表示移动到一个具体的坐标点(x, y)
                // scrollBy() 表示移动的增量为dx、dy

                // // 直接调用，移动的是 View 的 content。
                // // ViewGroup 的 content 是所有子View
                // // TextView 的 content 是它的文本
                // // ImageView 的 content 是它的 drawable 对象
                // scrollBy(offsetX, offsetY)
                // scrollTo(offsetX, offsetY)

                // 偏移量需要使用负数，才能看到移动效果
                // (parent as View).scrollBy(-offsetX, -offsetY)
                (parent as View).scrollTo((parent as View).scrollX - offsetX, (parent as View).scrollY - offsetY)

                // 重新设置初始坐标
                lastRawX = rawX
                lastRawY = rawY
            }
        }
    }
}