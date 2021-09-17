package kayroc.android.learn.ui.view.canvas

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import kayroc.android.learn.R


/**
 * Canvas clipPath的使用
 * @author kayroc
 */
class CanvasClipPathView @JvmOverloads constructor(
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

    private val mBitmap: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.android_boy)

    private val mPath: Path = Path()

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val left: Float = (width - mBitmap.width) / 2f
        val top: Float = (height - mBitmap.height) / 2f

        canvas?.save()
        mPath.addCircle(width / 2f, height / 2f - 80, 260f, Path.Direction.CW)
        canvas?.clipPath(mPath)
        canvas?.drawBitmap(mBitmap, left, top, mPaint)
        canvas?.restore()
    }

}