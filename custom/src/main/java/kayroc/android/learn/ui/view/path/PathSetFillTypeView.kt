package kayroc.android.learn.ui.view.path

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View


/**
 * Path setFillType的使用
 * @author kayroc
 */
class PathSetFillTypeView @JvmOverloads constructor(
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

    private val mPath: Path = Path()

    init {
        setLayerType(LAYER_TYPE_SOFTWARE, null)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        normal(canvas)
        winding(canvas)
        evenOdd(canvas)
        // inverseWinding(canvas)
        // inverseEvenOdd(canvas)
    }

    private fun inverseEvenOdd(canvas: Canvas?) {
        canvas?.save()
        canvas?.translate(500f, 800f)
        mPaint.style = Paint.Style.FILL
        mPath.reset()
        mPath.addCircle(200f, 200f, 120f, Path.Direction.CW)
        mPath.addCircle(200f, 200f, 80f, Path.Direction.CCW)
        mPath.addCircle(350f, 200f, 120f, Path.Direction.CW)
        mPath.fillType = Path.FillType.INVERSE_EVEN_ODD
        canvas?.drawPath(mPath, mPaint)
        canvas?.restore()
    }

    private fun evenOdd(canvas: Canvas?) {
        canvas?.save()
        canvas?.translate(0f, 800f)
        mPaint.style = Paint.Style.FILL
        mPath.reset()
        mPath.addCircle(200f, 200f, 120f, Path.Direction.CW)
        mPath.addCircle(200f, 200f, 80f, Path.Direction.CCW)
        mPath.addCircle(350f, 200f, 120f, Path.Direction.CW)
        mPath.fillType = Path.FillType.EVEN_ODD
        canvas?.drawPath(mPath, mPaint)
        canvas?.restore()
    }

    private fun inverseWinding(canvas: Canvas?) {
        canvas?.save()
        canvas?.translate(500f, 400f)
        mPaint.style = Paint.Style.FILL
        mPath.reset()
        mPath.addCircle(200f, 200f, 120f, Path.Direction.CW)
        mPath.addCircle(200f, 200f, 80f, Path.Direction.CCW)
        mPath.addCircle(350f, 200f, 120f, Path.Direction.CW)
        mPath.fillType = Path.FillType.INVERSE_WINDING
        canvas?.drawPath(mPath, mPaint)
        canvas?.restore()
    }

    private fun winding(canvas: Canvas?) {
        canvas?.save()
        canvas?.translate(0f, 400f)
        mPaint.style = Paint.Style.FILL
        mPath.reset()
        mPath.addCircle(200f, 200f, 120f, Path.Direction.CW)
        mPath.addCircle(200f, 200f, 80f, Path.Direction.CCW)
        mPath.addCircle(350f, 200f, 120f, Path.Direction.CW)
        mPath.fillType = Path.FillType.WINDING
        canvas?.drawPath(mPath, mPaint)
        canvas?.restore()
    }

    private fun normal(canvas: Canvas?) {
        canvas?.save()
        mPaint.style = Paint.Style.STROKE
        mPath.reset()
        mPath.addCircle(200f, 200f, 120f, Path.Direction.CW)
        mPath.addCircle(200f, 200f, 80f, Path.Direction.CCW)
        mPath.addCircle(350f, 200f, 120f, Path.Direction.CW)
        canvas?.drawPath(mPath, mPaint)
        canvas?.restore()
    }

}