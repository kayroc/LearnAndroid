package kayroc.android.learn.ui.view.paint

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import kayroc.android.learn.R


/**
 * Paint setShader的使用
 * 位图
 * @author kayroc
 */
class PaintShaderBitmapView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attributeSet, defStyleAttr) {

    private val mBitmap: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.batman)

    private val mPaint1: Paint = Paint().apply {
        // 启用抗锯齿
        isAntiAlias = true

        // 位图 着色器
        // bitmap: 用来做模板的 Bitmap 对象
        // tileX: 横向的 TileMode
        //     Shader.TileMode.CLAMP: 拉伸
        //     Shader.TileMode.MIRROR: 镜像
        //     Shader.TileMode.REPEAT: 平铺
        // tileY: 纵向的 TileMode
        //     Shader.TileMode.CLAMP: 拉伸
        //     Shader.TileMode.MIRROR: 镜像
        //     Shader.TileMode.REPEAT: 平铺
        shader = BitmapShader(mBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
    }

    private val mPaint2: Paint = Paint().apply {
        // 启用抗锯齿
        isAntiAlias = true

        // 位图 着色器
        // bitmap: 用来做模板的 Bitmap 对象
        // tileX: 横向的 TileMode
        //     Shader.TileMode.CLAMP: 拉伸
        //     Shader.TileMode.MIRROR: 镜像
        //     Shader.TileMode.REPEAT: 平铺
        // tileY: 纵向的 TileMode
        //     Shader.TileMode.CLAMP: 拉伸
        //     Shader.TileMode.MIRROR: 镜像
        //     Shader.TileMode.REPEAT: 平铺
        shader = BitmapShader(mBitmap, Shader.TileMode.MIRROR, Shader.TileMode.MIRROR)
    }

    private val mPaint3: Paint = Paint().apply {
        // 启用抗锯齿
        isAntiAlias = true

        // 位图 着色器
        // bitmap: 用来做模板的 Bitmap 对象
        // tileX: 横向的 TileMode
        //     Shader.TileMode.CLAMP: 拉伸
        //     Shader.TileMode.MIRROR: 镜像
        //     Shader.TileMode.REPEAT: 平铺
        // tileY: 纵向的 TileMode
        //     Shader.TileMode.CLAMP: 拉伸
        //     Shader.TileMode.MIRROR: 镜像
        //     Shader.TileMode.REPEAT: 平铺
        shader = BitmapShader(mBitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.drawRect(0f, 0f, width.toFloat(), height / 3f - 50, mPaint1)

        canvas?.drawRect(0f, height / 3f, width.toFloat(), height / 3f * 2 - 50, mPaint2)

        canvas?.drawRect(0f, height / 3f * 2, width.toFloat(), height.toFloat() - 50, mPaint3)
    }
}