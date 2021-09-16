package kayroc.android.learn.ui.view.canvas

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import kayroc.android.learn.R


/**
 * Canvas drawBitmap的使用
 * @author kayroc
 */
class CanvasDrawBitmapView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attributeSet, defStyleAttr) {

    private val mPaint: Paint = Paint().apply {
        // 启用抗锯齿
        isAntiAlias = true
        // 画笔宽度
        strokeWidth = 60f
    }

    private val mMatrix: Matrix = Matrix()

    private val mBitmap: Bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.android_boy)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        // 从坐标原点直接绘制
        // draw1(canvas)

        // 指定左上角坐标进行绘制
        draw2(canvas)

        // 指定绘制区域，指定图片显示区域
        // draw3(canvas)
    }

    private fun draw3(canvas: Canvas?) {
        // 将画布坐标系移动到画布中央
        canvas?.translate(width / 2f, height / 2f)
        // 指定图片绘制区域(左上角的四分之一)
        val src = Rect(0, 0, mBitmap.width / 2, mBitmap.height / 2)
        // 指定图片在屏幕上显示的区域
        val dst = Rect(0, 0, 200, 400)
        // 绘制图片
        canvas?.drawBitmap(mBitmap, src, dst, null)
    }

    private fun draw2(canvas: Canvas?) {
        // 计算图片左上角坐标，使其绘制在屏幕中间
        val left: Float = (width - mBitmap.width) / 2f
        val top: Float = (height - mBitmap.height) / 2f
        // 绘制图片
        canvas?.drawBitmap(mBitmap, left, top, mPaint)
    }

    private fun draw1(canvas: Canvas?) {
        // 绘制图片
        canvas?.drawBitmap(mBitmap, mMatrix, mPaint)
    }

}