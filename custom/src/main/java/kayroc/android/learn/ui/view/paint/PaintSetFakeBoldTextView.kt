package kayroc.android.learn.ui.view.paint

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View


/**
 * Paint setFakeBoldText的使用
 * @author kayroc
 */
class PaintSetFakeBoldTextView @JvmOverloads constructor(
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

        mPaint.isFakeBoldText = false
        canvas?.drawText(text, 100f, 150f, mPaint)

        mPaint.isFakeBoldText = true
        canvas?.drawText(text, 100f, 230f, mPaint)
    }
}