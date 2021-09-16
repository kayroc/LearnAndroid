package kayroc.android.learn.ui.view.canvas

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View


/**
 * Canvas Scale的使用
 * @author kayroc
 */
class CanvasScaleView @JvmOverloads constructor(
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

    // 左上角(0,-400) 右下角(400,0)
    private val rectF = RectF(0f, -400f, 400f, 0f)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        // 将坐标移动至屏幕中心
        canvas?.translate(width / 2f, height / 2f)

        // 绘制黑色矩形
        mPaint.color = Color.BLACK
        canvas?.drawRect(rectF, mPaint)

        // 画布缩放
        canvas?.scale(-0.5f, -0.5f)

        // 绘制蓝色矩形
        mPaint.color = Color.BLUE
        canvas?.drawRect(rectF, mPaint)
    }
}