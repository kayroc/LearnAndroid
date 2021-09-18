package kayroc.android.learn.ui.view.matrix

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import kayroc.android.learn.R
import kotlin.math.abs


/**
 * Matrix setPolyToPoly 的使用
 * @author kayroc
 */
class MatrixSetPolyToPolyView  @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attributeSet, defStyleAttr) {

    private val mPaint = Paint(Paint.ANTI_ALIAS_FLAG or Paint.DITHER_FLAG).apply{
        isAntiAlias = true
        strokeWidth = 50f
        color = Color.parseColor("#FFD19165")
        strokeCap = Paint.Cap.ROUND
    }

    private var pointCount = 0
    private val triggerRadius = 180 // 触发半径为180px

    // 要绘制的图片
    private val mBitmap: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.android_boy)

    private val src = floatArrayOf(0f, 0f, mBitmap.width.toFloat(), 0f, mBitmap.width.toFloat(), mBitmap.height.toFloat(), 0f, mBitmap.height.toFloat())
    private var dst = floatArrayOf(0f, 0f, mBitmap.width.toFloat(), 0f, mBitmap.width.toFloat(), mBitmap.height.toFloat(), 0f, mBitmap.height.toFloat())

    // 测试setPolyToPoly用的Matrix
    private val mPolyMatrix: Matrix = Matrix().apply {
        setPolyToPoly(src, 0, src, 0, 4)
    }

    @Suppress("MemberVisibilityCanBePrivate")
    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event!!.action) {
            MotionEvent.ACTION_MOVE -> {
                val tempX = event.x
                val tempY = event.y

                // 根据触控位置改变dst
                var i = 0
                while (i < pointCount * 2) {
                    if (abs(tempX - dst[i]) <= triggerRadius && abs(tempY - dst[i + 1]) <= triggerRadius) {
                        dst[i] = tempX - 100
                        dst[i + 1] = tempY - 100
                        break // 防止两个点的位置重合
                    }
                    i += 2
                }
                resetPolyMatrix(pointCount)
                invalidate()
            }
        }
        return true
    }

    private fun resetPolyMatrix(pointCount: Int) {
        mPolyMatrix.reset()
        // 核心要点
        mPolyMatrix.setPolyToPoly(src, 0, dst, 0, pointCount)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.translate(100f, 100f)

        // 根据Matrix绘制一个变换后的图片
        canvas?.drawBitmap(mBitmap, mPolyMatrix, null)

        mPolyMatrix.mapPoints(dst, src)

        // 绘制触控点
        var i = 0
        while (i < pointCount * 2) {
            canvas!!.drawPoint(dst[i], dst[i + 1], mPaint)
            i += 2
        }
    }

    fun setTestPoint(testPoint: Int) {
        pointCount = if (testPoint > 4 || testPoint < 0) 4 else testPoint
        dst = src.clone()
        resetPolyMatrix(pointCount)
        invalidate()
    }
}