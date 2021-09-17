package kayroc.android.learn.ui.view.paint

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * Paint setStrokeCap的使用
 * @author kayroc
 */
class PaintSetStrokeCapView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attributeSet, defStyleAttr) {

    private val mPaint1: Paint = Paint().apply {
        // 启用抗锯齿
        isAntiAlias = true
        // 线条宽度: 100px
        strokeWidth = 100f
        // 线条线帽: BUTT 无线帽，也是默认类型
        strokeCap = Paint.Cap.BUTT
    }

    private val mPaint2: Paint = Paint().apply {
        // 启用抗锯齿
        isAntiAlias = true
        // 线条宽度: 100px
        strokeWidth = 100f
        // 线条线帽: ROUND 以线条宽度为直径，在开头和结尾分别添加一个半圆
        strokeCap = Paint.Cap.ROUND
    }

    private val mPaint3: Paint = Paint().apply {
        // 启用抗锯齿
        isAntiAlias = true
        // 线条宽度: 100px
        strokeWidth = 100f
        // 线条线帽: SQUARE 以线条宽度为大小，在开头和结尾分别添加半个正方形
        strokeCap = Paint.Cap.SQUARE
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.drawLine(100f,100f, 500f, 100f, mPaint1)
        canvas?.drawLine(100f,300f, 500f, 300f, mPaint2)
        canvas?.drawLine(100f,500f, 500f, 500f, mPaint3)
    }
}