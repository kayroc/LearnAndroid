package kayroc.android.learn.ui.view.path

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View


/**
 * Path rXxxTo类方法的使用
 * @author kayroc
 */
class PathRXxxToView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attributeSet, defStyleAttr) {

    private val mPaint: Paint = Paint().apply {
        // 启用抗锯齿
        isAntiAlias = true
        // 画笔模式：描边
        style = Paint.Style.STROKE
        // 画笔宽度：10px
        strokeWidth = 10f
    }

    private val mPath: Path = Path()

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        lineTo(canvas)
        moveTo(canvas)
        quadTo(canvas)
        cubicTo(canvas)

    }

    private fun cubicTo(canvas: Canvas?) {
        canvas?.save()
        canvas?.translate(0f, 900f)
        mPath.reset()                      // 重置路径
        // mPath.moveTo(100f, 100f)
        // // 以(x1,y1)为控制点1，以(x2,y2)为控制点2，向终点(x3,y3)绘制一条三阶贝塞尔曲线
        // mPath.cubicTo(200f, 0f, 300f, 90f, 500f, 100f)

        mPath.moveTo(50f, 50f)        // 先将起始点移动至 (50,50)
        mPath.rMoveTo(50f, 50f)     // 再将起始点移动至 (100,100)
        mPath.rCubicTo(100f, -100f, 200f, -10f, 400f, 0f)
        canvas?.drawPath(mPath, mPaint)
        canvas?.restore()
    }

    private fun quadTo(canvas: Canvas?) {
        canvas?.save()
        canvas?.translate(0f, 600f)
        mPath.reset()                      // 重置路径
        // mPath.moveTo(100f, 100f)
        // // 以(x₁,y₁)为控制点，向终点(x₂,y₂)绘制一条二阶贝塞尔曲线
        // mPath.quadTo(200f, 0f, 400f, 100f)

        mPath.moveTo(50f, 50f)        // 先将起始点移动至 (50,50)
        mPath.rMoveTo(50f, 50f)     // 再将起始点移动至 (100,100)
        mPath.rQuadTo(100f, -100f, 300f, 0f)
        canvas?.drawPath(mPath, mPaint)
        canvas?.restore()
    }

    private fun moveTo(canvas: Canvas?) {

        canvas?.save()
        canvas?.translate(300f, 0f)
        mPath.reset()                      // 重置路径
        // 从 (100,100) 连接至 (300,300)
        // mPath.moveTo(100f, 100f)
        // mPath.lineTo(300f, 300f)

        mPath.moveTo(50f, 50f)        // 先将起始点移动至 (50,50)
        mPath.rMoveTo(50f, 50f)     // 再将起始点移动至 (100,100)
        mPath.rLineTo(200f, 200f)
        canvas?.drawPath(mPath, mPaint)
        canvas?.restore()
    }

    private fun lineTo(canvas: Canvas?) {
        canvas?.save()
        // 从 (0,0) 连接至 (300,300)
        mPath.reset()
        mPath.rLineTo(300f, 300f)
        canvas?.drawPath(mPath, mPaint)
        canvas?.restore()
    }

}