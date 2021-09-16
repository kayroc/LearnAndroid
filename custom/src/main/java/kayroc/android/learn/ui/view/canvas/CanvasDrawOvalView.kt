package kayroc.android.learn.ui.view.canvas

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View


/**
 * Canvas drawOval的使用
 * @author kayroc
 */
class CanvasDrawOvalView @JvmOverloads constructor(
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

        // 直接绘制椭圆 左上角(100,100) 右下角(600,200)
        canvas?.drawOval(100f, 100f, 600f, 400f, mPaint)

        canvas?.drawOval(rectF, mPaint)
    }
}