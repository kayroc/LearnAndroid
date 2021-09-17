package kayroc.android.learn.ui.view.paint

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.text.TextPaint
import android.util.AttributeSet
import android.view.View


/**
 * Paint setShadowLayout的使用
 * @author kayroc
 */
class PaintSetShadowLayoutView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attributeSet, defStyleAttr) {

    private val mTextPaint: TextPaint = TextPaint().apply {
        // 启用抗锯齿
        isAntiAlias = true
        // 设置文字对齐方式: 居中
        textAlign = Paint.Align.CENTER
        // 阴影效果
        setShadowLayer(10f, 0f, 0f, Color.RED)
        // 字体大小：100px
        textSize = 100f
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.translate(width / 2f, height / 2f)
        canvas?.drawText("ShadowLayout", 0f, 0f, mTextPaint)
    }
}