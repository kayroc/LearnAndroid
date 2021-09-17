package kayroc.android.learn.ui.view.paint

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

/**
 * Paint setStrokeJoin的使用
 * @author kayroc
 */
class PaintSetStrokeJoinView @JvmOverloads constructor(
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
        // 拐角类型: MITER 尖角 (默认模式)
        strokeJoin = Paint.Join.MITER
    }

    private val mPaint2: Paint = Paint().apply {
        // 启用抗锯齿
        isAntiAlias = true
        // 描边模式
        style = Paint.Style.STROKE
        // 线条宽度: 40px
        strokeWidth = 40f
        // 拐角类型: ROUND 圆角
        strokeJoin = Paint.Join.ROUND
    }

    private val mPaint3: Paint = Paint().apply {
        // 启用抗锯齿
        isAntiAlias = true
        // 描边模式
        style = Paint.Style.STROKE
        // 线条宽度: 40px
        strokeWidth = 40f
        // 拐角类型: BEVEL 平角
        strokeJoin = Paint.Join.BEVEL
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
        // 第三种形状：BEVEL
        canvas?.drawPath(mPath, mPaint3)
    }
}