package kayroc.android.learn.ui.view.path

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View


/**
 * Path addXxx类方法的使用
 * @author kayroc
 */
class PathAddXxxView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attributeSet, defStyleAttr) {

    private val mPaint: Paint = Paint().apply {
        // 启用抗锯齿
        isAntiAlias = true
        // 画笔模式：描边
        style = Paint.Style.STROKE
        // 画笔宽度：2px
        strokeWidth = 4f
    }

    private val mTextPaint: Paint = Paint().apply {
        // 启用抗锯齿
        isAntiAlias = true
        // 文字大小：44px (22sp)
        textSize = 44f
    }

    val rectF = RectF(100f, 100f, 400f, 200f)

    private val mPath: Path = Path()


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        addArc(canvas)
        addCircle(canvas)
        addOval(canvas)
        addRect(canvas)
        addRoundRect(canvas)
        addPath(canvas)
    }

    private fun addPath(canvas: Canvas?) {
        canvas?.save()
        canvas?.translate(0f, 1100f)
        mPath.reset()   // 重置路径
        mPath.addPath(Path().apply {
            moveTo(100f, 100f)
            lineTo(150f, 200f)
            quadTo(200f, 100f, 350f, 200f)
            lineTo(100f, 250f)
            close()
        })
        mPath.close()   // 关闭路径
        canvas?.drawPath(mPath, mPaint)
        canvas?.drawTextOnPath("绘制顺序", mPath, 0f, 0f, mTextPaint)
        canvas?.restore()
    }

    private fun addRoundRect(canvas: Canvas?) {
        canvas?.save()
        canvas?.translate(0f, 900f)
        mPath.reset()   // 重置路径
        mPath.addRoundRect(rectF, 10f, 10f, Path.Direction.CW) //顺时针绘制
        mPath.close()   // 关闭路径
        canvas?.drawPath(mPath, mPaint)
        canvas?.drawTextOnPath("绘制顺序", mPath, 0f, 0f, mTextPaint)
        canvas?.restore()

        canvas?.save()
        canvas?.translate(400f, 900f)
        mPath.reset()   // 重置路径
        mPath.addRoundRect(rectF, 10f, 10f, Path.Direction.CCW) //逆时针绘制
        mPath.close()   // 关闭路径
        canvas?.drawPath(mPath, mPaint)
        canvas?.drawTextOnPath("绘制顺序", mPath, 0f, 0f, mTextPaint)
        canvas?.restore()
    }

    private fun addRect(canvas: Canvas?) {
        canvas?.save()
        canvas?.translate(0f, 700f)
        mPath.reset()   // 重置路径
        mPath.addRect(rectF, Path.Direction.CW) //顺时针绘制
        mPath.close()   // 关闭路径
        canvas?.drawPath(mPath, mPaint)
        canvas?.drawTextOnPath("绘制顺序", mPath, 0f, 0f, mTextPaint)
        canvas?.restore()

        canvas?.save()
        canvas?.translate(400f, 700f)
        mPath.reset()   // 重置路径
        mPath.addRect(rectF, Path.Direction.CCW) //逆时针绘制
        mPath.close()   // 关闭路径
        canvas?.drawPath(mPath, mPaint)
        canvas?.drawTextOnPath("绘制顺序", mPath, 0f, 0f, mTextPaint)
        canvas?.restore()
    }

    private fun addOval(canvas: Canvas?) {
        canvas?.save()
        canvas?.translate(0f, 500f)
        mPath.reset()   // 重置路径
        mPath.addOval(rectF, Path.Direction.CW) //顺时针绘制
        mPath.close()   // 关闭路径
        canvas?.drawPath(mPath, mPaint)
        canvas?.drawTextOnPath("绘制顺序", mPath, 0f, 0f, mTextPaint)
        canvas?.restore()

        canvas?.save()
        canvas?.translate(400f, 500f)
        mPath.reset()   // 重置路径
        mPath.addOval(rectF, Path.Direction.CCW) //逆时针绘制
        mPath.close()   // 关闭路径
        canvas?.drawPath(mPath, mPaint)
        canvas?.drawTextOnPath("绘制顺序", mPath, 0f, 0f, mTextPaint)
        canvas?.restore()
    }

    private fun addCircle(canvas: Canvas?) {
        canvas?.save()
        canvas?.translate(0f, 200f)
        mPath.reset()   // 重置路径
        mPath.addCircle(200f, 200f, 150f, Path.Direction.CW) //顺时针绘制
        mPath.close()   // 关闭路径
        canvas?.drawPath(mPath, mPaint)
        canvas?.drawTextOnPath("绘制顺序", mPath, 0f, 0f, mTextPaint)
        canvas?.restore()

        canvas?.save()
        canvas?.translate(400f, 200f)
        mPath.reset()   // 重置路径
        mPath.addCircle(200f, 200f, 150f, Path.Direction.CCW) //逆时针绘制
        mPath.close()   // 关闭路径
        canvas?.drawPath(mPath, mPaint)
        canvas?.drawTextOnPath("绘制顺序", mPath, 0f, 0f, mTextPaint)
        canvas?.restore()
    }

    // 与
    // arcTo(RectF oval, float startAngle, float sweepAngle, boolean forceMoveTo)
    // 中 forceMoveTo 设置为 true 效果一致
    private fun addArc(canvas: Canvas?) {
        canvas?.save()
        mPath.reset()   // 重置路径
        // mPath.arcTo(rectF, 0f, 180f)
        // mPath.addArc(rectF, 0f, 180f)
        mPath.addArc(rectF, 270f, 180f)
        // mPath.close()   // 关闭路径
        canvas?.drawPath(mPath, mPaint)
        canvas?.drawTextOnPath("绘制顺序", mPath, 0f, 0f, mTextPaint)
        canvas?.restore()
    }

}