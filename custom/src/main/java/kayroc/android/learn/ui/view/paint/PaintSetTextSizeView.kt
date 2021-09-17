package kayroc.android.learn.ui.view.paint

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View


/**
 * Paint setTextSize的使用
 * @author kayroc
 */
class PaintSetTextSizeView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attributeSet, defStyleAttr) {

    private val text = "Android"

    private val mPaint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        mPaint.textSize = 36f
        canvas?.drawText(text, 100f, 50f, mPaint)

        mPaint.textSize = 60f
        canvas?.drawText(text, 100f, 150f, mPaint)

        mPaint.textSize = 80f
        canvas?.drawText(text, 100f, 250f, mPaint)

        mPaint.textSize = 120f
        canvas?.drawText(text, 100f, 400f, mPaint)
    }
}