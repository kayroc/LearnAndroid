package kayroc.android.learn.ui.view.paint

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.View


/**
 * Paint setTypeface的使用
 * @author kayroc
 */
class PaintSetTypefaceView @JvmOverloads constructor(
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

        mPaint.typeface = Typeface.DEFAULT
        canvas?.drawText(text, 100f, 150f, mPaint)

        mPaint.typeface = Typeface.DEFAULT_BOLD
        canvas?.drawText(text, 100f, 300f, mPaint)

        mPaint.typeface = Typeface.MONOSPACE
        canvas?.drawText(text, 100f, 450f, mPaint)

        mPaint.typeface = Typeface.SANS_SERIF
        canvas?.drawText(text, 100f, 600f, mPaint)

        mPaint.typeface = Typeface.SERIF
        canvas?.drawText(text, 100f, 750f, mPaint)

        mPaint.typeface = Typeface.createFromAsset(context.assets, "Satisfy-Regular.ttf")
        canvas?.drawText(text, 100f, 900f, mPaint)
    }
}