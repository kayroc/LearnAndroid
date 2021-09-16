package kayroc.android.learn.ui.view.canvas

import android.content.Context
import android.graphics.*
import android.graphics.drawable.PictureDrawable
import android.util.AttributeSet
import android.view.View


/**
 * Canvas drawPicture的使用
 * @author kayroc
 */
class CanvasDrawPictureView @JvmOverloads constructor(
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

    private val mPicture = Picture()
    private var pictureRectF: RectF
    private var pictureDrawable : PictureDrawable

    init {
        // 关闭硬件加速
        setLayerType(LAYER_TYPE_SOFTWARE, null)

        recording()

        pictureRectF = RectF(0f, 0f, mPicture.width.toFloat(), mPicture.height.toFloat())

        pictureDrawable = PictureDrawable(mPicture)
    }

    private fun recording() {
        // 开始录制 (接收返回值Canvas)
        val canvas = mPicture.beginRecording(500, 500)

        // 创建一个画笔
        val paint = Paint()
        paint.color = Color.BLUE
        paint.style = Paint.Style.FILL

        // 在Canvas中具体操作
        // 位移
        canvas.translate(250f, 250f)
        // 绘制一个圆
        canvas.drawCircle(0f, 0f, 100f, paint)

        // 结束录制
        mPicture.endRecording()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        // 使用Picture提供的draw方法绘制
        // draw1(canvas)

        // 使用Canvas提供的drawPicture方法绘制
        draw2(canvas)

        // 将Picture包装成为PictureDrawable，使用PictureDrawable的draw方法绘制
        // draw3(canvas)

    }

    private fun draw3(canvas: Canvas?) {
        // 设置绘制区域 -- 注意此处所绘制的实际内容不会缩放
        pictureDrawable.setBounds(0, 0, 250, mPicture.height)
        pictureDrawable.draw(canvas!!)
    }

    private fun draw2(canvas: Canvas?) {
        canvas?.drawPicture(mPicture, pictureRectF)
    }

    private fun draw1(canvas: Canvas?) {
        mPicture.draw(canvas!!)
    }
}