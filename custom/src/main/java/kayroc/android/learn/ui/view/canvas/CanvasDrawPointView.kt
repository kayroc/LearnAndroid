package kayroc.android.learn.ui.view.canvas

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * Canvas drawPoint的使用
 * @author kayroc
 */
class CanvasDrawPointView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attributeSet, defStyleAttr) {

    private val mPaint: Paint = Paint().apply {
        // 启用抗锯齿
        isAntiAlias = true
        // 画笔宽度
        strokeWidth = 10f
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        // 在坐标(200,200)位置绘制一个点
        canvas?.drawPoint(200f, 200f, mPaint)

        canvas?.drawPoint(300f, 300f, mPaint)

        // 绘制一组点
        canvas?.drawPoints(floatArrayOf(
            500f, 500f,     // 在坐标(500,500)位置绘制一个点
            500f, 600f,     // 在坐标(500,600)位置绘制一个点
            500f, 700f      // 在坐标(500,700)位置绘制一个点
        ), mPaint)
    }
}