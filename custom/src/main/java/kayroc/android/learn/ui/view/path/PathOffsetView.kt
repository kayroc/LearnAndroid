package kayroc.android.learn.ui.view.path

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View


/**
 * Path offset的使用
 * @author kayroc
 */
class PathOffsetView @JvmOverloads constructor(
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
        canvas!!.translate(width / 2f, height / 2f) // 移动坐标系到屏幕中心

        canvas.scale(1f, -1f) // <-- 注意 翻转y坐标轴

        val path = Path() // path中添加一个圆形(圆心在坐标原点)

        path.addCircle(0f, 0f, 100f, Path.Direction.CW)

        val dst = Path() // dst中添加一个矩形

        dst.addRect(-200f, -200f, 200f, 200f, Path.Direction.CW)

        // dx: x方向偏移量
        // dy: y方向偏移量
        // dst: 偏移后的 Path
        //    dst不为空(null): 将当前path平移后的状态存入dst中，不会影响当前path
        //    dst为空(null): 平移将作用于当前path，相当于 offset(dx, dy)
        path.offset(300f, 0f, dst) // 平移

        canvas.drawPath(path, mPaint) // 绘制path

        mPaint.color = Color.BLUE // 更改画笔颜色

        canvas.drawPath(dst, mPaint) // 绘制dst

    }
}