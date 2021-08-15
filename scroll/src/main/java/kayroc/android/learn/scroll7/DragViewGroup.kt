package kayroc.android.learn.scroll7

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.widget.FrameLayout
import androidx.core.view.ViewCompat
import androidx.customview.widget.ViewDragHelper


/**
 * QQ 滑动侧边栏
 * @author kayroc
 */
class DragViewGroup @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = android.R.attr.editTextStyle
) : FrameLayout(context, attributeSet, defStyleAttr) {

    private var mMenuView: View? = null
    private var mMainView: View? = null
    private var mWidth = 0

    private val callback: ViewDragHelper.Callback = object : ViewDragHelper.Callback() {
        // 何时开始检测触摸事件
        override fun tryCaptureView(child: View, pointerId: Int): Boolean {
            //如果当前触摸的child是mMainView时开始检测
            return mMainView === child
        }

        // 触摸到View后回调
        override fun onViewCaptured(capturedChild: View, activePointerId: Int) {
            super.onViewCaptured(capturedChild, activePointerId)
        }

        // 当拖拽状态改变，比如idle，dragging
        override fun onViewDragStateChanged(state: Int) {
            super.onViewDragStateChanged(state)
        }

        // 当位置改变的时候调用,常用与滑动时更改scale等
        override fun onViewPositionChanged(changedView: View,
            left: Int, top: Int, dx: Int, dy: Int) {
            super.onViewPositionChanged(changedView, left, top, dx, dy)
        }

        // 处理垂直滑动
        override fun clampViewPositionVertical(child: View, top: Int, dy: Int): Int {
            return 0
        }

        // 处理水平滑动
        override fun clampViewPositionHorizontal(child: View, left: Int, dx: Int): Int {
            return left
        }

        // 拖动结束后调用
        override fun onViewReleased(releasedChild: View, xvel: Float, yvel: Float) {
            super.onViewReleased(releasedChild, xvel, yvel)
            //手指抬起后缓慢移动到指定位置
            if (mMainView!!.left < 500) {
                //关闭菜单
                //相当于Scroller的startScroll方法
                mViewDragHelper!!.smoothSlideViewTo(mMainView!!, 0, 0)
                ViewCompat.postInvalidateOnAnimation(this@DragViewGroup)
            } else {
                //打开菜单
                mViewDragHelper!!.smoothSlideViewTo(mMainView!!, 300, 0)
                ViewCompat.postInvalidateOnAnimation(this@DragViewGroup)
            }
        }
    }

    private val mViewDragHelper: ViewDragHelper? = ViewDragHelper.create(this, callback)


    override fun computeScroll() {
        if (mViewDragHelper!!.continueSettling(true)) {
            ViewCompat.postInvalidateOnAnimation(this)
        }
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        // 重写事件拦截方法，将事件传递给ViewDragHelper进行处理
        return mViewDragHelper!!.shouldInterceptTouchEvent(ev!!)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        //将触摸事件传递给ViewDragHelper,此操作必不可少
        mViewDragHelper!!.processTouchEvent(event!!)
        return true
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        mMenuView = getChildAt(0)
        mMainView = getChildAt(1)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        mWidth = mMenuView!!.measuredWidth
    }
}