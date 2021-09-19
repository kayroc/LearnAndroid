package kayroc.android.learn.ui.view.event

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.widget.FrameLayout

class ViewGroupA @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attributeSet, defStyleAttr) {

    private val logTag = Static.TAG3

    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        if (ev.action == MotionEvent.ACTION_DOWN) {
            Log.i(logTag, Static.dispatchTouchEvent)
            // Log.i(logTag, Static.dispatchTouchEvent + "老板要做淘宝,下周上线?")
            // Log.i(logTag, Static.dispatchTouchEvent + "给按钮加上一道光.")
            Log.i(logTag, Static.dispatchTouchEvent + "项目进度?")
        }
        return super.dispatchTouchEvent(ev)
    }

    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
        if (ev.action == MotionEvent.ACTION_DOWN) {
            Log.i(logTag, Static.onInterceptTouchEvent)
            // Log.i(logTag, Static.onInterceptTouchEvent + "(看着不太靠谱,先问问小王怎么看)")
        }

        // return super.onInterceptTouchEvent(ev)
        return true
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (event.action == MotionEvent.ACTION_DOWN) {
            Log.i(logTag, Static.onTouchEvent)
            // Log.i(logTag, Static.onTouchEvent + "小王说做不了")
            Log.i(logTag, Static.onTouchEvent + "正在测试,明天就测试完了")
        }
        // return super.onTouchEvent(event)
        return true
    }
}