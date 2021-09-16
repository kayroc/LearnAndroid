package kayroc.android.learn.ui.view.canvas

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View


/**
 * Canvas drawRoundRect的使用
 * @author kayroc
 */
class CanvasDrawRoundRectView @JvmOverloads constructor(
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

    // 左上角(100,500) 右下角(600,800)
    private var rectF = RectF(100f, 500f, 600f, 800f)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        // 直接绘制圆角矩形 左上角(100,100) 右下角(600,400) 圆角横轴半径30，纵轴半径30
        canvas?.drawRoundRect(100f, 100f, 600f, 400f, 30f, 30f, mPaint)

        // 使用 RectF 绘制圆角矩形 圆角横轴半径30，纵轴半径30
        canvas?.drawRoundRect(rectF, 30f, 30f, mPaint)
    }
}