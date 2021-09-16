package kayroc.android.learn.ui.view.canvas

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import kayroc.android.learn.R


/**
 * Canvas clipRect的使用
 * @author kayroc
 */
class CanvasClipRectView @JvmOverloads constructor(
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

    private val mBitmap: Bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.android_boy)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val left: Float = (width - mBitmap.width) / 2f
        val top: Float = (height - mBitmap.height) / 2f

        canvas?.save()
        canvas?.clipRect(left + 260, top + 50, left + 690, top + 550)
        canvas?.drawBitmap(mBitmap, left, top, mPaint)
        canvas?.restore()
    }

}