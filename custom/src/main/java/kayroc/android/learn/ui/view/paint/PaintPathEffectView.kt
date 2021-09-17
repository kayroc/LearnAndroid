package kayroc.android.learn.ui.view.paint

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

/**
 * Paint PathEffect的使用
 * @author kayroc
 */
class PaintPathEffectView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attributeSet, defStyleAttr) {

    private val mPaint: Paint = Paint().apply {
        // 启用抗锯齿
        isAntiAlias = true
        // 描边模式
        style = Paint.Style.STROKE
    }
    
    private val mPath: Path = Path().apply {
        moveTo(50f, 100f)
        rLineTo(50f, 100f)
        rLineTo(80f, -150f)
        rLineTo(100f, 100f)
        rLineTo(70f, -120f)
        rLineTo(150f, 80f)
    }
    
    private val mDashPath = Path().apply {
        lineTo(20f, -30f)
        lineTo(40f, 0f)
        close()
    }

    // radius: 圆角的半径
    private var cornerPathEffect: PathEffect = CornerPathEffect(20f)
    // intervals[]: 间隔，用于控制虚线显示长度和隐藏长度，它必须为偶数(且至少为两个)，按照[显示长度，隐藏长度，显示长度，隐藏长度]的顺序来显示
    // phase: 相位(和正余弦函数中的相位类似，周期为intervals长度总和)，也可以简单的理解为偏移量
    private var discretePathEffect: PathEffect = DiscretePathEffect(20f, 5f)
    // shape: 用来绘制的 Path
    //      注意: shape 只能是 FILL 模式
    // advance: 是两个相邻的 shape 段之间的间隔
    //      注意: 这个间隔是两个 shape 段的起点的间隔，而不是前一个的终点和后一个的起点的距离
    // phase: 相位(和正余弦函数中的相位类似，周期为intervals长度总和)，也可以简单的理解为偏移量
    // style: 转角处的样式
    //      PathDashPathEffect.Style.TRANSLATE: 在转角处对图形平移
    //      PathDashPathEffect.Style.ROTATE: 在转角处对图形旋转
    //      PathDashPathEffect.Style.MORPH: 在转角处对图形变形
    private var dashPathEffect: PathEffect = DashPathEffect(floatArrayOf(20f, 10f, 5f, 10f), 0f)
    // segmentLength: 分段长度
    // deviation: 偏移距离
    private var pathDashPathEffect: PathEffect? = PathDashPathEffect(mDashPath, 50f, 0f, PathDashPathEffect.Style.MORPH)
    // SumPathEffect 用于合并两种效果，它相当于两种效果都绘制一遍
    private var sumPathEffect: PathEffect = SumPathEffect(dashPathEffect, discretePathEffect)
    // ComposePathEffect 也是合并两种效果，只不过先应用一种效果后，再次叠加另一种效果，因此交换参数最终得到的效果是不同的
    private var composePathEffect: PathEffect = ComposePathEffect(dashPathEffect, discretePathEffect)
    

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        // 第一处：CornerPathEffect
        mPaint.pathEffect = cornerPathEffect
        canvas?.drawPath(mPath, mPaint)

        canvas?.save()
        canvas?.translate(500f, 0f)
        // 第二处：DiscretePathEffect
        mPaint.pathEffect = discretePathEffect
        canvas?.drawPath(mPath, mPaint)
        canvas?.restore()

        canvas?.save()
        canvas?.translate(0f, 200f)
        // 第三处：DashPathEffect
        mPaint.pathEffect = dashPathEffect
        canvas?.drawPath(mPath, mPaint)
        canvas?.restore()

        canvas?.save()
        canvas?.translate(500f, 200f)
        // 第四处：PathDashPathEffect
        mPaint.pathEffect = pathDashPathEffect
        canvas?.drawPath(mPath, mPaint)
        canvas?.restore()

        canvas?.save()
        canvas?.translate(0f, 400f)
        // 第五处：SumPathEffect
        mPaint.pathEffect = sumPathEffect
        canvas?.drawPath(mPath, mPaint)
        canvas?.restore()

        canvas?.save()
        canvas?.translate(500f, 400f)
        // 第六处：ComposePathEffect
        mPaint.pathEffect = composePathEffect
        canvas?.drawPath(mPath, mPaint)
        canvas?.restore()
    }
}