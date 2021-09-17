package kayroc.android.learn.ui.view.paint

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import kayroc.android.learn.R

/**
 * Paint setFilterBitmap的使用
 * @author kayroc
 */
class PaintSetFilterBitmapView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attributeSet, defStyleAttr) {

    private val mPaint: Paint = Paint().apply {
        // 启用抗锯齿
        isAntiAlias = true
        // 画笔宽度
        strokeWidth = 60f
        // 设置双线性过滤，优化 Bitmap 放大绘制的效果
        isFilterBitmap = true
    }

    private val mBitmap: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.android_boy)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        // 计算图片左上角坐标，使其绘制在屏幕中间
        val left: Float = (width - mBitmap.width) / 2f
        val top: Float = (height - mBitmap.height) / 2f
        // 绘制图片
        canvas?.drawBitmap(mBitmap, left, top, mPaint)
    }
}