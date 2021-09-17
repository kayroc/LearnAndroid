package kayroc.android.learn.ui.view.paint

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

/**
 * Paint getFillPath的使用
 * @author kayroc
 */
class PaintGetFillPathView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attributeSet, defStyleAttr) {

    private val mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val mPathPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        // 画笔模式：描边
        style = Paint.Style.STROKE
    }

    private val mPath = Path().apply {
        moveTo(50f, 100f)
        rLineTo(50f, 100f)
        rLineTo(80f, -150f)
        rLineTo(100f, 100f)
        rLineTo(70f, -120f)
        rLineTo(150f, 80f)
    }
    private val mPath1 = Path()
    private val mPath2 = Path()
    private val mPath3 = Path()

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        // 第一处：获取 Path
        mPaint.style = Paint.Style.FILL_AND_STROKE
        mPaint.strokeWidth = 0f
        // src: 原 Path
        // dst: 实际 Path
        // getFillPath(src, dst) 会计算出实际 Path，然后把结果保存在 dst 里
        mPaint.getFillPath(mPath, mPath1)
        canvas?.drawPath(mPath, mPaint)

        canvas?.save()
        canvas?.translate(500f, 0f)
        canvas?.drawPath(mPath1, mPathPaint)
        canvas?.restore()

        canvas?.save()
        canvas?.translate(0f, 200f)
        // 第二处：设置 Style 为 STROKE 后再获取 Path
        mPaint.style = Paint.Style.STROKE
        mPaint.getFillPath(mPath, mPath2)
        canvas?.drawPath(mPath, mPaint)
        canvas?.restore()

        canvas?.save()
        canvas?.translate(500f, 200f)
        canvas?.drawPath(mPath2, mPathPaint)
        canvas?.restore()

        canvas?.save()
        canvas?.translate(0f, 400f)
        mPaint.strokeWidth = 40f
        // 第三处：Style 为 STROKE 并且线条宽度为 40 时的 Path
        mPaint.getFillPath(mPath, mPath3)
        canvas?.drawPath(mPath, mPaint)
        canvas?.restore()

        canvas?.save()
        canvas?.translate(500f, 400f)
        canvas?.drawPath(mPath3, mPathPaint)
        canvas?.restore()
    }
}