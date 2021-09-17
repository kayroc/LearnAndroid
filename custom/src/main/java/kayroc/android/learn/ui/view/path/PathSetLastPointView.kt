package kayroc.android.learn.ui.view.path

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View


/**
 * Path addXxx类方法的使用
 * @author kayroc
 */
class PathSetLastPointView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attributeSet, defStyleAttr) {

    private val mPaint: Paint = Paint().apply {
        // 启用抗锯齿
        isAntiAlias = true
        // 画笔模式：描边
        style = Paint.Style.STROKE
        // 画笔宽度：2px
        strokeWidth = 4f
    }

    private val mPath: Path = Path()


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.translate(width / 2f, height / 2f)

        mPath.lineTo(200f, 200f)

        mPath.setLastPoint(200f, 100f)

        mPath.lineTo(200f, 0f)

        canvas!!.drawPath(mPath, mPaint)
    }

}