package kayroc.android.learn.ui.view.paint

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import kayroc.android.learn.R


/**
 * Paint setXfermode的使用
 * @author kayroc
 */
class PaintSetXFerModeView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attributeSet, defStyleAttr) {

    private val bitmap1 = BitmapFactory.decodeResource(resources, R.drawable.batman)
    private val bitmap2 = BitmapFactory.decodeResource(resources, R.drawable.batman_logo)


    private val srcMode: Xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC)
    private val dstInMode: Xfermode = PorterDuffXfermode(PorterDuff.Mode.DST_IN)
    private val dstOutMode: Xfermode = PorterDuffXfermode(PorterDuff.Mode.DST_OUT)

    private val mPaint: Paint = Paint().apply {
        // 启用抗锯齿
        isAntiAlias = true
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        // 别忘了用 canvas?.saveLayer() 开启 off-screen buffer
        val saved = canvas?.saveLayer(null, null)

        canvas?.drawBitmap(bitmap1, 0f, 0f, mPaint)
        mPaint.xfermode = srcMode
        canvas?.drawBitmap(bitmap2, 0f, 0f, mPaint)
        mPaint.xfermode = null

        canvas?.drawBitmap(bitmap1, bitmap1.width + 100f, 0f, mPaint)
        mPaint.xfermode = dstInMode
        canvas?.drawBitmap(bitmap2, bitmap1.width + 100f, 0f, mPaint)
        mPaint.xfermode = null

        canvas?.drawBitmap(bitmap1, 0f, bitmap1.height + 20f, mPaint)
        mPaint.xfermode = dstOutMode
        canvas?.drawBitmap(bitmap2, 0f, bitmap1.height + 20f, mPaint)
        mPaint.xfermode = null

        // 用完之后使用 canvas?.restore() 恢复 off-screen buffer
        canvas?.restoreToCount(saved!!)
    }
}