package kayroc.android.learn.ui.view.paint

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import kayroc.android.learn.R


/**
 * Paint SetMaskFilter的使用
 * @author kayroc
 */
class PaintSetMaskFilterView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attributeSet, defStyleAttr) {

    private val mPaint: Paint = Paint().apply {
        // 启用抗锯齿
        isAntiAlias = true
    }

    private val mBitmap: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.what_the_fuck)

    // radius: 模糊范围
    // style: 模糊类型
    //      BlurMaskFilter.Blur.NORMAL: 内外都模糊绘制
    //      BlurMaskFilter.Blur.SOLID: 内部正常绘制，外部模糊
    //      BlurMaskFilter.Blur.INNER: 内部模糊，外部不绘制
    //      BlurMaskFilter.Blur.OUTER: 内部不绘制，外部模糊
    private val blurMaskFilter1: MaskFilter = BlurMaskFilter(50f, BlurMaskFilter.Blur.NORMAL)
    private val blurMaskFilter2: MaskFilter = BlurMaskFilter(50f, BlurMaskFilter.Blur.INNER)
    private val blurMaskFilter3: MaskFilter = BlurMaskFilter(50f, BlurMaskFilter.Blur.OUTER)
    private val blurMaskFilter4: MaskFilter = BlurMaskFilter(50f, BlurMaskFilter.Blur.SOLID)

    // direction: 是一个 3 个元素的数组，指定了光源的方向 (x, y, z)
    // ambient: 环境光的强度，数值范围是 0 到 1
    // specular: 炫光的系数
    // blurRadius: 应用光线的范围
    private val embossMaskFilter: MaskFilter = EmbossMaskFilter(floatArrayOf(0f, 1f, 1f), 0.5f, 5f, 10f)

    init {
        setLayerType(LAYER_TYPE_SOFTWARE, null)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        mPaint.maskFilter = blurMaskFilter1
        canvas?.drawBitmap(mBitmap, 100f, 50f, mPaint)

        mPaint.maskFilter = blurMaskFilter2
        canvas?.drawBitmap(mBitmap, mBitmap.width + 200f, 50f, mPaint)

        mPaint.maskFilter = blurMaskFilter3
        canvas?.drawBitmap(mBitmap, 100f, mBitmap.height + 100f, mPaint)

        mPaint.maskFilter = blurMaskFilter4
        canvas?.drawBitmap(mBitmap, mBitmap.width + 200f, mBitmap.height + 100f, mPaint)

        mPaint.maskFilter = embossMaskFilter
        canvas?.drawBitmap(mBitmap, 100f, (mBitmap.height + 100f) * 2, mPaint)
    }
}