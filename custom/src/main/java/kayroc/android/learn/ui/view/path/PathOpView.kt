package kayroc.android.learn.ui.view.path

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View


/**
 * Path op的使用
 * @author kayroc
 */
class PathOpView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attributeSet, defStyleAttr) {

    private val mPaint: Paint = Paint().apply {
        // 启用抗锯齿
        isAntiAlias = true
        // 画笔模式：描边
        style = Paint.Style.FILL
        // 画笔宽度：2px
        strokeWidth = 4f
    }

    private val mTextPaint: Paint = Paint().apply {
        // 启用抗锯齿
        isAntiAlias = true
        // 字体大小：48px 24sp
        textSize = 48f
    }

    private val path1 = Path()
    private val path2 = Path()
    private val pathOpResult = Path()


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val x = 80
        val r = 100

        canvas?.translate(250f, 0f)

        path1.addCircle(-x.toFloat(), 0f, r.toFloat(), Path.Direction.CW)
        path2.addCircle(x.toFloat(), 0f, r.toFloat(), Path.Direction.CW)

        pathOpResult.op(path1, path2, Path.Op.DIFFERENCE)
        canvas?.translate(0f, 120f)
        canvas?.drawText("DIFFERENCE", 240f, 0f, mTextPaint)
        canvas?.drawPath(pathOpResult, mPaint)

        pathOpResult.op(path1, path2, Path.Op.REVERSE_DIFFERENCE)
        canvas?.translate(0f, 300f)
        canvas?.drawText("REVERSE_DIFFERENCE", 240f, 0f, mTextPaint)
        canvas?.drawPath(pathOpResult, mPaint)

        pathOpResult.op(path1, path2, Path.Op.INTERSECT)
        canvas?.translate(0f, 300f)
        canvas?.drawText("INTERSECT", 240f, 0f, mTextPaint)
        canvas?.drawPath(pathOpResult, mPaint)

        pathOpResult.op(path1, path2, Path.Op.UNION)
        canvas?.translate(0f, 300f)
        canvas?.drawText("UNION", 240f, 0f, mTextPaint)
        canvas?.drawPath(pathOpResult, mPaint)

        pathOpResult.op(path1, path2, Path.Op.XOR)
        canvas?.translate(0f, 300f)
        canvas?.drawText("XOR", 240f, 0f, mTextPaint)
        canvas?.drawPath(pathOpResult, mPaint)
    }

}