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
 * Canvas save和restore的使用
 * @author kayroc
 */
class CanvasSaveAndRestoreView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attributeSet, defStyleAttr) {

    private val mPaint: Paint = Paint().apply {
        // 启用抗锯齿
        isAntiAlias = true
        // 画笔宽度
        strokeWidth = 10f
    }

    private val mBitmap: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.maps)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.drawBitmap(mBitmap, 100f, 100f, mPaint)

        canvas?.save()      // 保存画布状态
        canvas?.translate(900f, 500f)
        canvas?.rotate(90f)
        canvas?.drawBitmap(mBitmap, 0f, 0f, mPaint)
        canvas?.restore()   // 取出画布状态

        canvas?.save()      // 保存画布状态
        canvas?.translate(100f, 900f)
        canvas?.drawBitmap(mBitmap, 0f, 0f, mPaint)
        canvas?.restore()   // 取出画布状态

    }
}