package kayroc.android.learn.ui.view.path

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View


/**
 * Path xxxTo类方法的使用
 * @author kayroc
 */
class PathXxxToView @JvmOverloads constructor(
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
        arcTo(canvas)
        quadTo(canvas)
        cubicTo(canvas)

    }

    private fun cubicTo(canvas: Canvas?) {
        canvas?.save()
        canvas?.translate(0f, 1200f)
        mPath.reset()   // 重置路径
        mPath.moveTo(100f, 100f)
        // 以(x1,y1)为控制点1，以(x2,y2)为控制点2，向终点(x3,y3)绘制一条三阶贝塞尔曲线
        mPath.cubicTo(200f, 0f, 300f, 90f, 500f, 100f)
        canvas?.drawPath(mPath, mPaint)
        canvas?.restore()
    }

    private fun quadTo(canvas: Canvas?) {
        canvas?.save()
        canvas?.translate(0f, 900f)
        mPath.reset()   // 重置路径
        mPath.moveTo(100f, 100f)
        // 以(x₁,y₁)为控制点，向终点(x₂,y₂)绘制一条二阶贝塞尔曲线
        mPath.quadTo(200f, 0f, 400f, 100f)
        canvas?.drawPath(mPath, mPaint)
        canvas?.restore()
    }

    private fun arcTo(canvas: Canvas?) {
        val rectF = RectF(100f, 100f, 300f, 400f)

        // forceMoveTo 为 false
        canvas?.save()
        canvas?.translate(0f, 300f)
        mPath.reset()   // 重置路径
        mPath.moveTo(100f, 100f)
        mPath.arcTo(rectF, 0f, 180f, false)
        mPath.close()   // 关闭路径
        canvas?.drawPath(mPath, mPaint)
        canvas?.restore()

        // forceMoveTo 为 true
        canvas?.save()
        canvas?.translate(300f, 300f)
        mPath.reset()   // 重置路径
        mPath.moveTo(100f, 100f)
        mPath.arcTo(rectF, 0f, 180f, true)
        mPath.close()   // 关闭路径
        canvas?.drawPath(mPath, mPaint)
        canvas?.restore()

        canvas?.save()
        canvas?.translate(600f, 300f)
        mPath.reset()   // 重置路径
        mPath.arcTo(rectF, 0f, 180f)
        mPath.close()   // 关闭路径
        canvas?.drawPath(mPath, mPaint)
        canvas?.restore()
    }

    private fun moveTo(canvas: Canvas?) {

        canvas?.save()
        canvas?.translate(300f, 0f)
        // 从 (100,100) 连接至 (300,300)
        mPath.reset()   // 重置路径
        mPath.moveTo(100f, 100f)
        mPath.lineTo(300f, 300f)
        canvas?.drawPath(mPath, mPaint)
        canvas?.restore()
    }

    private fun lineTo(canvas: Canvas?) {
        canvas?.save()
        // 从 (0,0) 连接至 (300,300)
        mPath.reset()   // 重置路径
        mPath.lineTo(300f, 300f)
        canvas?.drawPath(mPath, mPaint)
        canvas?.restore()
    }

}