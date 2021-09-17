package kayroc.android.learn.ui.view.paint

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View


/**
 * Paint setShader的使用
 * 径向渐变/辐射渐变
 * @author kayroc
 */
class PaintShaderRadialGradientView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attributeSet, defStyleAttr) {

    private val mPaint1: Paint = Paint().apply {
        // 启用抗锯齿
        isAntiAlias = true

        // 径向渐变/辐射渐变 着色器
        // centerX: 辐射中心x坐标 centerY: 辐射中心y坐标
        // radius: 辐射半径
        // centerColor: 辐射中心的颜色
        // edgeColor: 辐射边缘的颜色
        // tileMode: 辐射范围之外的着色模式
        //     Shader.TileMode.CLAMP: 拉伸
        //     Shader.TileMode.MIRROR: 镜像
        //     Shader.TileMode.REPEAT: 平铺
        shader = RadialGradient(300f, 300f, 100f, // 左上角坐标(100,100) 右下角坐标(500,500)
            Color.parseColor("#E91E63"),
            Color.parseColor("#2196F3"),
            Shader.TileMode.CLAMP)
    }

    private val mPaint2: Paint = Paint().apply {
        // 启用抗锯齿
        isAntiAlias = true

        // 径向渐变/辐射渐变 着色器
        // centerX: 辐射中心x坐标 centerY: 辐射中心y坐标
        // radius: 辐射半径
        // centerColor: 辐射中心的颜色
        // edgeColor: 辐射边缘的颜色
        // tileMode: 辐射范围之外的着色模式
        //     Shader.TileMode.CLAMP: 拉伸
        //     Shader.TileMode.MIRROR: 镜像
        //     Shader.TileMode.REPEAT: 平铺
        shader = RadialGradient(300f, 800f, 100f, // 左上角坐标(600,100) 右下角坐标(1000,500)
            Color.parseColor("#E91E63"),
            Color.parseColor("#2196F3"),
            Shader.TileMode.MIRROR)
    }

    private val mPaint3: Paint = Paint().apply {
        // 启用抗锯齿
        isAntiAlias = true

        // 径向渐变/辐射渐变 着色器
        // centerX: 辐射中心x坐标 centerY: 辐射中心y坐标
        // radius: 辐射半径
        // centerColor: 辐射中心的颜色
        // edgeColor: 辐射边缘的颜色
        // tileMode: 辐射范围之外的着色模式
        //     Shader.TileMode.CLAMP: 拉伸
        //     Shader.TileMode.MIRROR: 镜像
        //     Shader.TileMode.REPEAT: 平铺
        shader = RadialGradient(300f, 300f, 100f,    // 左上角坐标(100,600) 右下角坐标(500,1000)
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