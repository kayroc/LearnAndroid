package kayroc.android.learn.ui.view.event

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.widget.RelativeLayout

class RootView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : RelativeLayout(context, attributeSet, defStyleAttr) {

    private val logTag = Static.TAG2

    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        if (ev.action == MotionEvent.ACTION_DOWN) {
            Log.i(logTag, Static.dispatchTouchEvent)
            // Log.i(logTag, Static.dispatchTouchEvent + "呼叫技术部,老板要做淘宝,下周上线.")
            // Log.i(logTag, Static.dispatchTouchEvent + "技术部,老板说按钮不好看,要加一道光.")
            Log.i(logTag, Static.dispatchTouchEvent + "技术部,你们的app快做完了么?")
        }
        return super.dispatchTouchEvent(ev)
    }

    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
        if (ev.action == MotionEvent.ACTION_DOWN) {
            Log.i(logTag, Static.onInterceptTouchEvent)
            // Log.i(logTag, Static.onInterceptTouchEvent + "(老板可能疯了,但又不是我做.)")
        }
        return super.onInterceptTouchEvent(ev)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (event.action == MotionEvent.ACTION_DOWN) {
            Log.i(logTag, Static.onTouchEvent)
            // Log.i(logTag, Static.onTouchEvent+"报告老板, 技术部说做不了")
        }
        return super.onTouchEvent(event)
    }

}