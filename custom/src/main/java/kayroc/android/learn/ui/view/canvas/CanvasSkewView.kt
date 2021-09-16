package kayroc.android.learn.ui.view.canvas

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

/**
 * Canvas Skew的使用
 * @author kayroc
 */
class CanvasSkewView @JvmOverloads constructor(
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

    // 左上角(0,-0) 右下角(200,200)
    private val rectF = RectF(0f, 0f, 200f, 200f)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        // 将坐标移动至(200,200)
        canvas?.translate(200f, 200f)

        // 绘制黑色矩形
        mPaint.color = Color.BLACK
        canvas?.drawRect(rectF, mPaint)

        // 水平错切
        canvas?.skew(1f, 0f)
        // 垂直错切
        canvas?.skew(0f, 1f)

        // 绘制蓝色矩形
        mPaint.color = Color.BLUE
        canvas?.drawRect(rectF, mPaint)
    }
}