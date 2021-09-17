package kayroc.android.learn.ui.view.paint

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import kayroc.android.learn.R


/**
 * Paint setShader的使用
 * 混合
 * @author kayroc
 */
class PaintShaderComposeView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attributeSet, defStyleAttr) {

    private val bitmap1 = BitmapFactory.decodeResource(resources, R.drawable.batman)
    private val bitmap2 = BitmapFactory.decodeResource(resources, R.drawable.batman_logo)
    private val shader1: Shader = BitmapShader(bitmap1, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
    private val shader2: Shader = BitmapShader(bitmap2, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)

    private val mPaint1: Paint = Paint().apply {
        // 启用抗锯齿
        isAntiAlias = true

        // 混合 着色器
        // shaderA: 着色器"dst"
        // shaderB: 着色器"src"
        // mode: 两个Shader的叠加模式，即shaderA和shaderB应该怎样共同绘制
        shader = ComposeShader(shader1, shader2, PorterDuff.Mode.SRC_OVER)
    }

    private val mPaint2: Paint = Paint().apply {
        // 启用抗锯齿
        isAntiAlias = true

        // 混合 着色器
        // shaderA: 着色器"dst"
        // shaderB: 着色器"src"
        // mode: 两个Shader的叠加模式，即shaderA和shaderB应该怎样共同绘制
        shader = ComposeShader(shader1, shader2, PorterDuff.Mode.DST_OUT)
    }

    private val mPaint3: Paint = Paint().apply {
        // 启用抗锯齿
        isAntiAlias = true

        // 混合 着色器
        // shaderA: 着色器"dst"
        // shaderB: 着色器"src"
        // mode: 两个Shader的叠加模式，即shaderA和shaderB应该怎样共同绘制
        shader = ComposeShader(shader1, shader2, PorterDuff.Mode.DST_IN)
    }

    init {
        setLayerType(LAYER_TYPE_SOFTWARE, null)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.save()
        canvas?.drawCircle(200f, 200f, 200f, mPaint1)
        canvas?.restore()

        canvas?.save()
        canvas?.translate(0f, 500f)
        canvas?.drawCircle(200f, 200f, 200f, mPaint2)
        canvas?.restore()

        canvas?.save()
        canvas?.translate(0f, 900f)
        canvas?.drawCircle(200f, 200f, 200f, mPaint3)
        canvas?.restore()
    }
}