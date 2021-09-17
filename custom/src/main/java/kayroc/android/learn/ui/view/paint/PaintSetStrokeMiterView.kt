package kayroc.android.learn.ui.view.paint

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

/**
 * Paint setStrokeMiter的使用
 * @author kayroc
 */
class PaintSetStrokeMiterView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attributeSet, defStyleAttr) {

    private val mPaint1: Paint = Paint().apply {
        // 启用抗锯齿
        isAntiAlias = true
        // 描边模式
        style = Paint.Style.STROKE
        // 线条宽度: 40px
        strokeWidth = 40f
        // 斜接限制: 1
        strokeMiter = 1f
    }

    private val mPaint2: Paint = Paint().apply {
        // 启用抗锯齿
        isAntiAlias = true
        // 描边模式
        style = Paint.Style.STROKE
        // 线条宽度: 40px
        strokeWidth = 40f
        // 斜接限制: 2
        strokeMiter = 2f
    }

    private val mPaint3: Paint = Paint().apply {
        // 启用抗锯齿
        isAntiAlias = true
        // 描边模式
        style = Paint.Style.STROKE
        // 线条宽度: 40px
        strokeWidth = 40f
        // 斜接限制: 5
        strokeMiter = 5f
    }

    private val mPath: Path = Path().apply { 
        rLineTo(200f, 0f)
        rLineTo(-160f, 120f)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.translate(100f, 100f)
        // 第一种形状：MITER
        canvas?.drawPath(mPath, mPaint1)

        canvas?.translate(300f, 0f)
        // 第二种形状：ROUND
        canvas?.drawPath(mPath, mPaint2)

        canvas?.translate(300f, 0f)
        // MITER 值：5
        canvas?.drawPath(mPath, mPaint3)
    }
}