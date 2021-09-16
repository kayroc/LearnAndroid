package kayroc.android.learn.ui.view.canvas

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * Canvas drawLine的使用
 * @author kayroc
 */
class CanvasDrawLineView @JvmOverloads constructor(
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

        // 在坐标(300,300)(500,600)之间绘制一条直线
        canvas?.drawLine(300f, 300f, 500f, 600f, mPaint)

        canvas?.drawLines(floatArrayOf(
            100f, 200f, 200f, 200f,     // 在坐标(100,200)(200,200)之间绘制一条直线
            100f, 300f, 200f, 300f      // 在坐标(100,300)(200,300)之间绘制一条直线
        ), mPaint)
    }
}