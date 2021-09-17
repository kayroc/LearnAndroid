package kayroc.android.learn.ui.view.paint

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View


/**
 * Paint setAntiAlias的使用
 * @author kayroc
 */
class PaintSetAntiAliasView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attributeSet, defStyleAttr) {

    private val mPaint1: Paint = Paint().apply {
        // 启用抗锯齿
        isAntiAlias = true
        strokeWidth = 100f
    }

    private val mPaint2: Paint = Paint().apply {
        // 禁用抗锯齿
        isAntiAlias = false
        strokeWidth = 100f
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.drawRect(100f, 100f, 300f, 300f, mPaint1)
        canvas?.drawRect(100f, 600f, 300f, 800f, mPaint2)

        canvas?.drawCircle(500f, 200f, 100f, mPaint1)
        canvas?.drawCircle(500f, 700f, 100f, mPaint2)
    }
}