package kayroc.android.learn.ui.view.paint

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View


/**
 * Paint setTextSkewX的使用
 * @author kayroc
 */
class PaintSetTextSkewXView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attributeSet, defStyleAttr) {

    private val text = "Android"

    private val mPaint: Paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        textSize = 56f
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        mPaint.textSkewX = -0.5f
        canvas?.drawText(text, 100f, 150f, mPaint)

        mPaint.textSkewX = -0.25f
        canvas?.drawText(text, 100f, 300f, mPaint)

        mPaint.textSkewX = 0f   // 默认
        canvas?.drawText(text, 100f, 450f, mPaint)

        mPaint.textSkewX = 0.25f
        canvas?.drawText(text, 100f, 600f, mPaint)

        mPaint.textSkewX = 0.5f
        canvas?.drawText(text, 100f, 750f, mPaint)

    }
}