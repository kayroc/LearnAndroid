package kayroc.android.learn.ui.view.paint

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View


/**
 * Paint setTextAlign的使用
 * @author kayroc
 */
class PaintSetTextAlignView @JvmOverloads constructor(
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

        mPaint.textAlign = Paint.Align.LEFT
        canvas?.drawText(text, 500f, 150f, mPaint)

        mPaint.textAlign = Paint.Align.CENTER
        canvas?.drawText(text, 500f, 300f, mPaint)

        mPaint.textAlign = Paint.Align.RIGHT
        canvas?.drawText(text, 500f, 450f, mPaint)

    }
}