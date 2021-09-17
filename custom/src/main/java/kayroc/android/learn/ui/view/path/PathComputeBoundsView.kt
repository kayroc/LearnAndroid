package kayroc.android.learn.ui.view.path

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View


/**
 * Path computeBounds的使用
 * @author kayroc
 */
class PathComputeBoundsView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attributeSet, defStyleAttr) {

    private val mPaint = Paint(Paint.ANTI_ALIAS_FLAG or Paint.DITHER_FLAG)


    init {
        setLayerType(LAYER_TYPE_SOFTWARE, null)
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        // 移动canvas,mViewWidth与mViewHeight在 onSizeChanged 方法中获得
        canvas?.translate(width / 2f, height / 2f)

        val rect1 = RectF() // 存放测量结果的矩形

        val path = Path() // 创建Path并添加一些内容

        path.lineTo(100f, -50f)
        path.lineTo(100f, 50f)
        path.close()
        path.addCircle(-100f, 0f, 100f, Path.Direction.CW)

        // bounds: 测量结果会放入这个矩形
        // exact: 是否精确测量，目前这一个参数作用已经废弃，一般写true即可。

        // bounds: 测量结果会放入这个矩形
        // exact: 是否精确测量，目前这一个参数作用已经废弃，一般写true即可。
        path.computeBounds(rect1, true) // 测量Path

        canvas?.drawPath(path, mPaint) // 绘制Path

        mPaint.style = Paint.Style.STROKE
        mPaint.color = Color.RED
        mPaint.strokeWidth = 10f
        canvas?.drawRect(rect1, mPaint) // 绘制边界

    }

}