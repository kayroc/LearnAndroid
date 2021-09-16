package kayroc.android.learn.ui.view.canvas

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * Canvas Translate的使用
 * @author kayroc
 */
class CanvasTranslateView @JvmOverloads constructor(
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

        // 在坐标原点绘制一个黑色圆形
        mPaint.color = Color.BLACK
        canvas?.translate(200f, 200f)       // 移动坐标原点至(200,200)
        canvas?.drawCircle(0f, 0f, 100f, mPaint)

        // 在坐标原点绘制一个蓝色圆形
        mPaint.color = Color.BLUE
        canvas?.translate(200f, 200f)       // 移动坐标原点至(200,200)
        canvas?.drawCircle(0f, 0f, 100f, mPaint)
    }
}