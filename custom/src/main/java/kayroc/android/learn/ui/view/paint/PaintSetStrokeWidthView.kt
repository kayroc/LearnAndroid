package kayroc.android.learn.ui.view.paint

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * Paint setStrokeWidth的使用
 * @author kayroc
 */
class PaintSetStrokeWidthView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attributeSet, defStyleAttr) {

    private val mPaint1: Paint = Paint().apply {
        // 启用抗锯齿
        isAntiAlias = true
        // 描边模式
        style = Paint.Style.STROKE

        // 线条宽度0px
        strokeWidth = 0f    // 不受画布缩放影响
    }

    private val mPaint2: Paint = Paint().apply {
        // 启用抗锯齿
        isAntiAlias = true
        // 描边模式
        style = Paint.Style.STROKE

        // 线条宽度10px
        strokeWidth = 10f   // 受画布缩放影响
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)


        canvas?.drawLine(100f,100f, 500f, 100f, mPaint1)
        canvas?.drawLine(100f,300f, 500f, 300f, mPaint2)

        // 放大画布
        canvas?.scale(1.5f, 1.5f)

        canvas?.drawLine(100f,500f, 500f, 500f, mPaint1)
        canvas?.drawLine(100f,700f, 500f, 700f, mPaint2)
    }
}