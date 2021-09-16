package kayroc.android.learn.ui.view.canvas

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View


/**
 * Canvas drawText的使用
 * @author kayroc
 */
class CanvasDrawTextView @JvmOverloads constructor(
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

    // 左上角(100,300) 右下角(600,400)
    private val rect = Rect(100, 300, 600, 400)
    // 左上角(100,500) 右下角(600,600)
    private val rectF = RectF(100f, 500f, 600f, 600f)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        // 直接绘制矩形 左上角(100,100) 右下角(600,200)
        canvas?.drawRect(100f, 100f, 600f, 200f, mPaint)

        // 使用 Rect 绘制矩形
        canvas?.drawRect(rect, mPaint)

        // 使用 RectF 绘制矩形
        canvas?.drawRect(rectF, mPaint)
    }
}