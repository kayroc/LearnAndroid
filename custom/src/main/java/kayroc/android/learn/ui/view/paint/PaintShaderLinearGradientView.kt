package kayroc.android.learn.ui.view.paint

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View


/**
 * Paint setShader的使用
 * @author kayroc
 */
class PaintShaderLinearGradientView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attributeSet, defStyleAttr) {

    private val mPaint1: Paint = Paint().apply {
        // 启用抗锯齿
        isAntiAlias = true

        // 线性渐变 着色器
        // x0: 渐变起始点x坐标 y0: 渐变起始点y坐标
        // x1: 渐变结束点x坐标 y1: 渐变结束点y坐标
        // color0: 渐变起始颜色 color1: 渐变结束颜色
        // tile: 着色规则，类型是TileMode
        //     Shader.TileMode.CLAMP: 拉伸
        //     Shader.TileMode.MIRROR: 镜像
        //     Shader.TileMode.REPEAT: 平铺
        shader = LinearGradient(100f, 100f, 200f, 200f, // 100f, 100f, 500f, 500f
            Color.parseColor("#E91E63"),
            Color.parseColor("#2196F3"),
            Shader.TileMode.CLAMP)
    }

    private val mPaint2: Paint = Paint().apply {
        // 启用抗锯齿
        isAntiAlias = true

        // 线性渐变 着色器
        // x0: 渐变起始点x坐标 y0: 渐变起始点y坐标
        // x1: 渐变结束点x坐标 y1: 渐变结束点y坐标
        // color0: 渐变起始颜色 color1: 渐变结束颜色
        // tile: 着色规则，类型是TileMode
        //     Shader.TileMode.CLAMP: 拉伸
        //     Shader.TileMode.MIRROR: 镜像
        //     Shader.TileMode.REPEAT: 平铺
        shader = LinearGradient(600f, 100f, 700f, 200f, // 600f, 100f, 1000f, 500f
            Color.parseColor("#E91E63"),
            Color.parseColor("#2196F3"),
            Shader.TileMode.MIRROR)
    }

    private val mPaint3: Paint = Paint().apply {
        // 启用抗锯齿
        isAntiAlias = true

        // 线性渐变 着色器
        // x0: 渐变起始点x坐标 y0: 渐变起始点y坐标
        // x1: 渐变结束点x坐标 y1: 渐变结束点y坐标
        // color0: 渐变起始颜色 color1: 渐变结束颜色
        // tile: 着色规则，类型是TileMode
        //     Shader.TileMode.CLAMP: 拉伸
        //     Shader.TileMode.MIRROR: 镜像
        //     Shader.TileMode.REPEAT: 平铺
        shader = LinearGradient(100f, 600f, 200f, 700f,    // 100f, 600f, 500f, 1000f
            Color.parseColor("#E91E63"),
            Color.parseColor("#2196F3"),
            Shader.TileMode.REPEAT)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.drawRect(100f, 100f, 500f, 500f, mPaint1)
        canvas?.drawRect(600f, 100f, 1000f, 500f, mPaint2)
        canvas?.drawRect(100f, 600f, 500f, 1000f, mPaint3)
    }
}