package kayroc.android.learn.ui.view.paint

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View


/**
 * Paint setTextScaleX的使用
 * @author kayroc
 */
class PaintSetTextScaleXView @JvmOverloads constructor(
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

        mPaint.textScaleX = 0.5f
        canvas?.drawText(text, 100f, 300f, mPaint)

        mPaint.textScaleX = 1f  // 默认
        canvas?.drawText(text, 100f, 150f, mPaint)

        mPaint.textScaleX = 1.5f
        canvas?.drawText(text, 100f, 450f, mPaint)

    }
}