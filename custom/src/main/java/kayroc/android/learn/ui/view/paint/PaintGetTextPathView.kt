package kayroc.android.learn.ui.view.paint

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

/**
 * Paint getTextPath的使用
 * @author kayroc
 */
class PaintGetTextPathView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attributeSet, defStyleAttr) {

    private val text = "Android"

    private val mPath = Path()

    private val mPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        textSize = 120f
        // text: 待获取的文本内容
        // start: 开始位置的索引
        // end: 结束位置的索引
        // x: 文本原点的 x 坐标
        // y: 文本远点的 y 坐标
        // path: 接收描述文本的数据的路径。必须由调用者分配
        getTextPath(text, 0, text.length, 50f, 400f, mPath)
    }

    private val mPathPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        // 画笔模式：描边
        style = Paint.Style.STROKE
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.drawText(text, 50f, 200f, mPaint)

        canvas?.drawPath(mPath, mPathPaint)
    }
}