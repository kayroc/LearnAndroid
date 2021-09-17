package kayroc.android.learn.ui.view.paint

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import kayroc.android.learn.R


/**
 * Paint setColorFilter的使用
 * @author kayroc
 */
class PaintSetColorFilterView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attributeSet, defStyleAttr) {

    private val bitmap = BitmapFactory.decodeResource(resources, R.drawable.batman)

    private val mPaint: Paint = Paint().apply {
        // 启用抗锯齿
        isAntiAlias = true
        // 字体大小
        textSize = 32f
    }

    private val mLightingPaint: Paint = Paint().apply {
        // 禁用抗锯齿
        isAntiAlias = false

        // 模拟简单的光照效果
        // mul全称是colorMultiply意为色彩倍增
        // add全称是colorAdd意为色彩添加
        // colorFilter = LightingColorFilter(0x00ffff, 0x000000)   // 保持原样
        colorFilter = LightingColorFilter(0xffffff, 0x003000)   // 去掉原像素中的红色
    }

    private val mPorterDuffPaint: Paint = Paint().apply {
        // 禁用抗锯齿
        isAntiAlias = false

        // 使用一个指定的颜色和一种指定的 PorterDuff.Mode 来与绘制对象进行合成
        colorFilter = PorterDuffColorFilter(Color.RED, PorterDuff.Mode.DARKEN)

    }

    private val mColorMatrixPaint: Paint = Paint().apply {
        // 禁用抗锯齿
        isAntiAlias = false

        // 使用一个指定的颜色和一种指定的 PorterDuff.Mode 来与绘制对象进行合成
        val colorMatrix = ColorMatrix()
        colorMatrix.setSaturation(0f) // 去饱和度

        colorFilter = ColorMatrixColorFilter(colorMatrix)

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.save()
        canvas?.translate(150f, 0f)
        canvas?.drawBitmap(bitmap, 0f, 0f, mPaint)
        canvas?.drawBitmap(bitmap, bitmap.width + 100f, 0f, mLightingPaint)
        canvas?.drawText("LightingColorFilter", 0f, bitmap.height + 50f, mPaint)
        canvas?.restore()

        canvas?.save()
        canvas?.translate(150f, bitmap.height + 100f)
        canvas?.drawBitmap(bitmap, 0f, 0f, mPaint)
        canvas?.drawBitmap(bitmap, bitmap.width + 100f, 0f, mPorterDuffPaint)
        canvas?.drawText("PorterDuffColorFilter", 0f, bitmap.height + 50f, mPaint)
        canvas?.restore()

        canvas?.save()
        canvas?.translate(150f, (bitmap.height + 100f) * 2)
        canvas?.drawBitmap(bitmap, 0f, 0f, mPaint)
        canvas?.drawBitmap(bitmap, bitmap.width + 100f, 0f, mColorMatrixPaint)
        canvas?.drawText("ColorMatrixColorFilter", 0f, bitmap.height + 50f, mPaint)
        canvas?.restore()
    }
}