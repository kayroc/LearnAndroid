package kayroc.android.learn.ui.view.paint

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * Paint setStyle的使用
 * @author kayroc
 */
class PaintSetStyleView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attributeSet, defStyleAttr) {

    private val mPaint1: Paint = Paint().apply {
        // 启用抗锯齿
        isAntiAlias = true
        // 画笔宽度: 10px
        strokeWidth = 10f
        // 画笔模式: 填充，默认
        style = Paint.Style.FILL
    }

    private val mPaint2: Paint = Paint().apply {
        // 启用抗锯齿
        isAntiAlias = true
        // 画笔宽度: 10px
        strokeWidth = 10f
        // 画笔模式: 描边
        style = Paint.Style.STROKE
    }

    private val mPaint3: Paint = Paint().apply {
        // 启用抗锯齿
        isAntiAlias = true
        // 画笔宽度: 10px
        strokeWidth = 10f
        // 画笔模式: 描边 + 填充
        style = Paint.Style.FILL_AND_STROKE
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.drawCircle(500f, 200f, 100f, mPaint1)

        canvas?.drawCircle(500f, 500f, 100f, mPaint2)

        canvas?.drawCircle(500f, 800f, 100f, mPaint3)

    }
}