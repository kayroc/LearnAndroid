package kayroc.android.learn.ui.view.paint

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.text.TextPaint
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.core.content.res.ResourcesCompat
import kayroc.android.learn.R


/**
 * Paint 画笔基础：创建方式及基本颜色
 * @author kayroc
 */
class PaintBasicView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attributeSet, defStyleAttr) {

    // 方式1：创建一个默认画笔，使用默认的配置
    private val mPaint1: Paint = Paint().apply {
        // 设置透明度，下面两种设置方式是等价的，一种是 10 进制，一种是 16 进制
        alpha = 204 // 10 进制参数范围：0 - 255
        alpha = 0xCC // 16 进制参数范围：0x00 - 0xFF

        // 设置ARGB颜色，下面两种设置方式是等价的，一种是 10 进制，一种是 16 进制
        setARGB(204, 255, 255, 0) // 10 进制参数范围：0 - 255
        setARGB(0xCC, 0xFF, 0xFF, 0x00) // 16 进制参数范围：0x00 - 0xFF

        // 设置系统内置的一些标准颜色
        color = Color.GREEN
        // 设置自定义颜色 注意：必须 ARGB 同时存在，否则什么颜色也绘制不出来
        color = -0x1d5a78 // 0xFFE2A588，其中 FF 表示 Alpha 通道
        color = 0xE2A588 // 0xE2A588，没有 Alpha 通道，什么颜色也绘制不出来

        // setColor 不能直接引用资源，如果想要使用预定义的颜色资源，可以像下面这样调用：
        color = ResourcesCompat.getColor(resources, R.color.black, null)
    }

    // 方式2：创建一个新画笔，并通过 flags 参数进行配置
    private val mPaint2 = Paint(Paint.ANTI_ALIAS_FLAG or Paint.DITHER_FLAG)

    // 方式3：创建一个新画笔，并复制参数中画笔的设置
    private val mPaint3: Paint = Paint(mPaint2).apply {
        // 启用抗锯齿
        isAntiAlias = false
    }

    // 文字画笔
    private val mTextPaint: TextPaint = TextPaint(mPaint1).apply {
        // 设置文字对齐方式: 居中
        textAlign = Paint.Align.CENTER
        textSize = 56f
    }

    init {
        Log.i("paint", "paint1 isAntiAlias = " + mPaint1.isAntiAlias)     // paint1 isAntiAlias = false
        Log.i("paint", "paint1 isDither = " + mPaint1.isDither)           // paint1 isDither = false

        Log.i("paint", "paint2 isAntiAlias = " + mPaint2.isAntiAlias)     // paint2 isAntiAlias = true
        Log.i("paint", "paint2 isDither = " + mPaint2.isDither)           // paint2 isDither = true

        Log.i("paint", "paint3 isAntiAlias = " + mPaint3.isAntiAlias)     // paint3 isAntiAlias = false
        Log.i("paint", "paint3 isDither = " + mPaint3.isDither)           // paint3 isDither = true
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.translate(width / 2f, height / 2f)
        canvas?.drawText("画笔基础：创建方式及基本颜色", 0f, 0f, mTextPaint)

    }
}