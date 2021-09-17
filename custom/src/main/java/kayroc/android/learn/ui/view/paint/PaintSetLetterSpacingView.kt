package kayroc.android.learn.ui.view.paint

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View


/**
 * Paint setLetterSpacing的使用
 * @author kayroc
 */
class PaintSetLetterSpacingView @JvmOverloads constructor(
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

        mPaint.letterSpacing = 0f
        canvas?.drawText(text, 100f, 150f, mPaint)

        mPaint.letterSpacing = 0.05f
        canvas?.drawText(text, 100f, 300f, mPaint)

        mPaint.letterSpacing = 0.2f
        canvas?.drawText(text, 100f, 450f, mPaint)

        mPaint.letterSpacing = 0.5f
        canvas?.drawText(text, 100f, 600f, mPaint)

    }
}