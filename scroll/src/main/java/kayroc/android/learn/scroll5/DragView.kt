package kayroc.android.learn.scroll5

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.widget.Scroller

/**
 * @author kayroc
 */
class DragView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = android.R.attr.editTextStyle
) : View(context, attributeSet, defStyleAttr) {

    private var lastX = 0
    private var lastY = 0
    private val mScroller = Scroller(context)

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event == null) {
            return false
        }
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

                // 偏移量需要使用负数，才能看到移动效果
                (parent as View).scrollBy(-offsetX, -offsetY)
            }
            MotionEvent.ACTION_UP -> {
                //手指离开时，执行滑动过程
                val viewGroup: View = parent as View
                mScroller.startScroll(
                    viewGroup.scrollX,
                    viewGroup.scrollY,
                    -viewGroup.scrollX,
                    -viewGroup.scrollY,
                    3000
                )

                invalidate()
            }
        }
        return super.onTouchEvent(event)
    }

    override fun computeScroll() {
        super.computeScroll()
        // 判断Scroller是否执行完毕
        if (mScroller.computeScrollOffset()) {
            (parent as View).scrollTo(
                mScroller.currX,
                mScroller.currY
            )
            // 通过重绘来不断调用computeScroll
            invalidate()
        }
    }
}