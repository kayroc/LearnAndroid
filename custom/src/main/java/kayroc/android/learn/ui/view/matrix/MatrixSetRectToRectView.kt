package kayroc.android.learn.ui.view.matrix

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import kayroc.android.learn.R


/**
 * Matrix setRectToRect 的使用
 * @author kayroc
 */
class MatrixSetRectToRectView  @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attributeSet, defStyleAttr) {

    private val mPaint = Paint(Paint.ANTI_ALIAS_FLAG or Paint.DITHER_FLAG).apply{
        isAntiAlias = true
        strokeWidth = 50f
        color = Color.parseColor("#FFD19165")
        strokeCap = Paint.Cap.ROUND
    }

    private val mBitmap: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.android_boy)

    private val mRectMatrix: Matrix = Matrix()

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        fill(canvas)
        start(canvas)
        center(canvas)
        end(canvas)
    }

    private fun end(canvas: Canvas?) {
        val srcRectF = RectF(0f, 0f, mBitmap.width.toFloat(), mBitmap.height.toFloat())
        val dstRectF = RectF(32f, 32f,  width / 2f - 32f, height / 2f - 32f)

        canvas?.save()
        canvas?.translate(width / 2f, height / 2f)
        // 将目标区域的矩形画出来
        mPaint.color = Color.GRAY
        canvas?.drawRect(dstRectF, mPaint)
        // 核心要点
        mRectMatrix.setRectToRect(srcRectF, dstRectF, Matrix.ScaleToFit.END)
        // 根据Matrix绘制一个变换后的图片
        canvas?.drawBitmap(mBitmap, mRectMatrix, mPaint)
        canvas?.restore()
    }

    private fun center(canvas: Canvas?) {
        val srcRectF = RectF(0f, 0f, mBitmap.width.toFloat(), mBitmap.height.toFloat())
        val dstRectF = RectF(32f, 32f,  width / 2f - 32f, height / 2f - 32f)

        canvas?.save()
        canvas?.translate(0f, height / 2f)
        // 将目标区域的矩形画出来
        mPaint.color = Color.GRAY
        canvas?.drawRect(dstRectF, mPaint)
        // 核心要点
        mRectMatrix.setRectToRect(srcRectF, dstRectF, Matrix.ScaleToFit.CENTER)
        // 根据Matrix绘制一个变换后的图片
        canvas?.drawBitmap(mBitmap, mRectMatrix, mPaint)
        canvas?.restore()
    }

    private fun start(canvas: Canvas?) {
        val srcRectF = RectF(0f, 0f, mBitmap.width.toFloat(), mBitmap.height.toFloat())
        val dstRectF = RectF(32f, 32f,  width / 2f - 32f, height / 2f - 32f)

        canvas?.save()
        canvas?.translate(width / 2f, 0f)
        // 将目标区域的矩形画出来
        mPaint.color = Color.GRAY
        canvas?.drawRect(dstRectF, mPaint)
        // 核心要点
        mRectMatrix.setRectToRect(srcRectF, dstRectF, Matrix.ScaleToFit.START)
        // 根据Matrix绘制一个变换后的图片
        canvas?.drawBitmap(mBitmap, mRectMatrix, mPaint)
        canvas?.restore()
    }

    private fun fill(canvas: Canvas?) {
        val srcRectF = RectF(0f, 0f, mBitmap.width.toFloat(), mBitmap.height.toFloat())
        val dstRectF = RectF(32f, 32f,  width / 2f - 32f, height / 2f - 32f)

        canvas?.save()
        // 将目标区域的矩形画出来
        mPaint.color = Color.GRAY
        canvas?.drawRect(dstRectF, mPaint)
        // 核心要点
        mRectMatrix.setRectToRect(srcRectF, dstRectF, Matrix.ScaleToFit.FILL)
        // 根据Matrix绘制一个变换后的图片
        canvas?.drawBitmap(mBitmap, mRectMatrix, mPaint)
        canvas?.restore()
    }

}