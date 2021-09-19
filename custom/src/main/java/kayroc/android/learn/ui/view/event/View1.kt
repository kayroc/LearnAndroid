package kayroc.android.learn.ui.view.event

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View

class View1 @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attributeSet, defStyleAttr) {

    private val logTag = Static.TAG4

    override fun dispatchTouchEvent(event: MotionEvent): Boolean {
        if (event.action == MotionEvent.ACTION_DOWN) {
            Log.i(logTag, Static.dispatchTouchEvent)
            // Log.i(logTag, Static.dispatchTouchEvent + "做淘宝???")
            // Log.i(logTag, Static.dispatchTouchEvent + "加一道光.")
        }
        return super.dispatchTouchEvent(event)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (event.action == MotionEvent.ACTION_DOWN) {
            Log.i(logTag, Static.onTouchEvent)
            // Log.i(logTag, Static.onTouchEvent + "这个真心做不了啊")
            // Log.i(logTag, Static.onTouchEvent + "做好了.")
        }
        return super.onTouchEvent(event)
        // return true
    }
}