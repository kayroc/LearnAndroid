package kayroc.android.learn.ui.view.paint

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.SweepGradient
import android.util.AttributeSet
import android.view.View


/**
 * Paint setShader的使用
 * 扫描渐变
 * @author kayroc
 */
class PaintShaderSweepGradientView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attributeSet, defStyleAttr) {

    private val mPaint: Paint = Paint().apply {
        // 启用抗锯齿
        isAntiAlias = true

        // 扫描渐变 着色器
        // cx: 扫描的中心x坐标 cy: 扫描的中心y坐标
        // color0: 扫描的起始颜色
        // color1: 扫描的终止颜色
        shader = SweepGradient(300f, 300f, Color.parseColor("#E91E63"),
            Color.parseColor("#2196F3"))
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.drawCircle(300f, 300f, 200f, mPaint)
    }
}