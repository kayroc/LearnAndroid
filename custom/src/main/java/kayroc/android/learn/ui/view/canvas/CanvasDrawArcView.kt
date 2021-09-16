package kayroc.android.learn.ui.view.canvas

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View


/**
 * Canvas drawArc的使用
 * @author kayroc
 */
class CanvasDrawArcView @JvmOverloads constructor(
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

    // 左上角(100,500) 右下角(600,400)
    private var rectF1 = RectF(100f, 100f, 600f, 400f)
    // 左上角(100,500) 右下角(600,400)
    private var rectF2 = RectF(100f, 500f, 500f, 900f)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        // 绘制矩形，方便观察
        mPaint.color = Color.GRAY
        canvas?.drawRect(rectF1, mPaint)
        // 绘制圆弧
        mPaint.color = Color.BLUE
        canvas?.drawArc(rectF1, 0f, 90f, false, mPaint)

        /*--------------------------------*/

        // 绘制矩形，方便观察
        mPaint.color = Color.GRAY
        canvas?.drawRect(rectF2, mPaint)
        // 绘制圆弧
        mPaint.color = Color.BLUE
        canvas?.drawArc(rectF2, 0f, 90f, true, mPaint)
    }
}