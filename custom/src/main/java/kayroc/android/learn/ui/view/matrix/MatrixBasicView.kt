package kayroc.android.learn.ui.view.matrix

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Matrix
import android.graphics.Paint
import android.graphics.RectF
import android.text.Layout
import android.text.StaticLayout
import android.text.TextPaint
import android.util.AttributeSet
import android.util.Log
import android.view.View


/**
 * Matrix 矩阵基础
 * @author kayroc
 */
class MatrixBasicView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attributeSet, defStyleAttr) {

    private val mPaint = Paint(Paint.ANTI_ALIAS_FLAG or Paint.DITHER_FLAG)

    // 文字画笔
    private val mTextPaint: TextPaint = TextPaint(mPaint).apply {
        // 设置文字对齐方式: 居中
        textAlign = Paint.Align.CENTER
        textSize = 56f
    }

    init {
        // 构造方法
        matrixCreate()

        // 基本方法
        matrixEquals()
        matrixHashCode()
        matrixToString()
        matrixToShortString()

        // 数值操作
        matrixSet()
        matrixReset()
        matrixSetValues()
        matrixGetValues()

        // 数值计算
        matrixMapPoints()
        matrixMapRadius()
        matrixMapRect()
        matrixMapVectors()

        // 特殊方法
        setSin()
    }

    private fun setSin() {
        val matrix = Matrix()
        // 旋转90度
        // sin90=1
        // cos90=0
        matrix.setSinCos(1f, 0f)

        Log.i("Matrix", "setSinCos:" + matrix.toShortString()) // [0.0, -1.0, 0.0][1.0, 0.0, 0.0][0.0, 0.0, 1.0]

        // 重置
        matrix.reset()

        // 旋转90度
        matrix.setRotate(90f)

        Log.i("Matrix", "setRotate:" + matrix.toShortString()) // [0.0, -1.0, 0.0][1.0, 0.0, 0.0][0.0, 0.0, 1.0]
    }

    /**
     * 计算向量变换后的位置
     */
    private fun matrixMapVectors() {
        val src = floatArrayOf(1000f, 800f)
        val dst = FloatArray(2)

        // 构造一个matrix
        val matrix = Matrix()
        matrix.setScale(0.5f, 1f)
        matrix.postTranslate(100f, 100f)

        // 计算向量, 不受位移影响
        matrix.mapVectors(dst, src)
        Log.i("Matrix", dst.contentToString()) // [500.0, 800.0]

        // 计算点
        matrix.mapPoints(dst, src)
        Log.i("Matrix", dst.contentToString()) // [600.0, 900.0]
    }

    /**
     * 计算矩形变换后的位置
     */
    private fun matrixMapRect() {
        val rect = RectF(400f, 400f, 1000f, 800f)

        // 构造一个matrix
        val matrix = Matrix()
        matrix.setScale(0.5f, 1f)
        matrix.postSkew(1f, 0f)

        Log.i("Matrix", rect.toString()) // RectF(400.0, 400.0, 1000.0, 800.0)

        // 测量rect并将测量结果放入rect
        // 返回值: 判断矩形经过变换后是否仍为矩形
        //      true: 是
        //      false: 否
        val result = matrix.mapRect(rect)

        Log.i("Matrix", rect.toString()) // RectF(600.0, 400.0, 1300.0, 800.0)

        // 由于使用了错切，所以结果应为false
        Log.e("Matrix", result.toString()) // false
    }

    /**
     * 计算半径变换后的位置
     */
    private fun matrixMapRadius() {
        val radius = 100f
        var result = 0f

        // 构造一个matrix，x坐标缩放0.5
        val matrix = Matrix()
        matrix.setScale(0.5f, 1f)

        Log.i("Matrix", radius.toString()) // 100.0

        result = matrix.mapRadius(radius)

        Log.i("Matrix", result.toString()) // 70.71068
    }

    /**
     * 计算点变换后的位置
     */
    private fun matrixMapPoints() {
        matrixMapPoints1()
        matrixMapPoints2()
        matrixMapPoints3()
    }

    private fun matrixMapPoints3() {
        /*---void mapPoints (float[] dst, int dstIndex, float[] src, int srcIndex, int pointCount)---*/

        // 初始数据为三个点 (0, 0) (80, 100) (400, 300)
        val src = floatArrayOf(0f, 0f, 80f, 100f, 400f, 300f)
        val dst = FloatArray(6)

        // 构造一个matrix，x坐标缩放0.5
        val matrix = Matrix()
        matrix.setScale(0.5f, 1f)

        // 输出计算之前数据
        Log.i("Matrix", "src=" + src.contentToString()) // src=[0.0, 0.0, 80.0, 100.0, 400.0, 300.0]
        Log.i("Matrix", "dst=" + dst.contentToString()) // dst=[0.0, 0.0, 0.0, 0.0, 0.0, 0.0]

        // dst: 目标数据
        // dstIndex: 目标数据存储位置起始下标
        // src: 源数据
        // srcIndex: 源数据存储位置起始下标
        // pointCount: 计算的点个数
        matrix.mapPoints(dst, 0, src, 2, 2) // 将第二、三个点计算后存储进dst最开始位置

        // 输出计算之后数据
        Log.i("Matrix", "src=" + src.contentToString()) // src=[0.0, 0.0, 80.0, 100.0, 400.0, 300.0]
        Log.i("Matrix", "dst=" + dst.contentToString()) // dst=[40.0, 100.0, 200.0, 300.0, 0.0, 0.0]
    }

    private fun matrixMapPoints2() {
        /*-----void mapPoints(float[] dst, float[] src)-----*/
        val src = floatArrayOf(0f, 0f, 80f, 100f, 400f, 300f)
        val dst = FloatArray(6)

        // 构造一个matrix，x坐标缩放0.5
        val matrix = Matrix()
        matrix.setScale(0.5f, 1f)

        // 输出计算之前数据
        Log.i("Matrix", "src=" + src.contentToString()) // src=[0.0, 0.0, 80.0, 100.0, 400.0, 300.0]

        Log.i("Matrix", "dst=" + dst.contentToString()) // dst=[0.0, 0.0, 0.0, 0.0, 0.0, 0.0]

        // src作为参数传递原始数值，计算结果存放在dst中，src不变。
        // 如果原始数据需要保留则一般使用这种方法
        matrix.mapPoints(dst, src)

        // 输出计算之后数据
        Log.i("Matrix", "src=" + src.contentToString()) // src=[0.0, 0.0, 80.0, 100.0, 400.0, 300.0]

        Log.i("Matrix", "dst=" + dst.contentToString()) // dst=[0.0, 0.0, 40.0, 100.0, 200.0, 300.0]

    }

    private fun matrixMapPoints1() {
        /*-----------void mapPoints (float[] pts)-----------*/

        // 初始数据为三个点 (0, 0) (80, 100) (400, 300)
        val pts = floatArrayOf(0f, 0f, 80f, 100f, 400f, 300f)

        // 构造一个matrix，x坐标缩放0.5
        val matrix = Matrix()
        matrix.setScale(0.5f, 1f)

        // 输出计算之前数据
        Log.i("Matrix", pts.contentToString()) // [0.0, 0.0, 80.0, 100.0, 400.0, 300.0]

        // pts数组作为参数传递原始数值，计算结果仍存放在pts中
        matrix.mapPoints(pts)

        // 输出计算之后数据
        Log.i("Matrix", pts.contentToString()) // [0.0, 0.0, 40.0, 100.0, 200.0, 300.0]
    }

    private fun matrixGetValues() {
        val matrix = Matrix()
        Log.d("Matrix", matrix.toShortString())     // [1.0, 0.0, 0.0][0.0, 1.0, 0.0][0.0, 0.0, 1.0]

        val floats = floatArrayOf(1f, 0f, 0f, 1f, 0f, 0f, 1f, 0f, 0f) // 数组长度不能小于9，否则报错

        matrix.getValues(floats)
        Log.d("Matrix", matrix.toShortString())     // [1.0, 0.0, 0.0][0.0, 1.0, 0.0][0.0, 0.0, 1.0]

        Log.d("Matrix", floats.contentToString())   // [1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0]


        val floats2 = floatArrayOf(0f, 1f, 0f, 0f, 1f, 0f, 0f, 1f, 0f) // 数组长度不能小于9，否则报错

        matrix.setRotate(10f)
        matrix.getValues(floats2)
        Log.d("Matrix", matrix.toShortString())     // [0.9848077, -0.17364818, 0.0][0.17364818, 0.9848077, 0.0][0.0, 0.0, 1.0]

        Log.d("Matrix", floats2.contentToString())  // [0.9848077, -0.17364818, 0.0, 0.17364818, 0.9848077, 0.0, 0.0, 0.0, 1.0]
    }

    private fun matrixSetValues() {
        val matrix = Matrix()
        Log.d("Matrix", matrix.toShortString())     // [1.0, 0.0, 0.0][0.0, 1.0, 0.0][0.0, 0.0, 1.0]

        val floats = floatArrayOf(1f, 0f, 0f, 1f, 0f, 0f, 1f, 0f, 0f) // 数组长度不能小于9，否则报错

        matrix.setValues(floats)
        Log.d("Matrix", matrix.toShortString())     // [1.0, 0.0, 0.0][1.0, 0.0, 0.0][1.0, 0.0, 0.0]

        Log.d("Matrix", floats.contentToString())   // [1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0]


        val floats2 = floatArrayOf(0f, 1f, 0f, 0f, 1f, 0f, 0f, 1f, 0f) //数组长度不能小于9，否则报错

        matrix.setValues(floats2)
        matrix.setRotate(10f)
        Log.d("Matrix", matrix.toShortString())     // [0.9848077, -0.17364818, 0.0][0.17364818, 0.9848077, 0.0][0.0, 0.0, 1.0]

        Log.d("Matrix", floats2.contentToString())  // [0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0]
    }

    private fun matrixReset() {
        val matrix = Matrix()
        Log.d("Matrix", matrix.toShortString()) // [1.0, 0.0, 0.0][0.0, 1.0, 0.0][0.0, 0.0, 1.0]

        matrix.setRotate(10f)
        Log.d("Matrix", matrix.toShortString()) // [0.9848077, -0.17364818, 0.0][0.17364818, 0.9848077, 0.0][0.0, 0.0, 1.0]

        matrix.reset()
        Log.d("Matrix", matrix.toShortString()) // [1.0, 0.0, 0.0][0.0, 1.0, 0.0][0.0, 0.0, 1.0]
    }

    private fun matrixSet() {
        val src = Matrix()
        src.setRotate(10f)
        Log.d("Matrix", src.toShortString())    // [0.9848077, -0.17364818, 0.0][0.17364818, 0.9848077, 0.0][0.0, 0.0, 1.0]

        val matrix = Matrix()
        Log.d("Matrix", matrix.toShortString()) // [1.0, 0.0, 0.0][0.0, 1.0, 0.0][0.0, 0.0, 1.0]

        matrix.set(src)
        Log.d("Matrix", matrix.toShortString()) // [0.9848077, -0.17364818, 0.0][0.17364818, 0.9848077, 0.0][0.0, 0.0, 1.0]

        matrix.set(null)                            // src为null时，会重置当前Matrix，相当于 reset()
        Log.d("Matrix", matrix.toShortString()) // [1.0, 0.0, 0.0][0.0, 1.0, 0.0][0.0, 0.0, 1.0]
    }

    private fun matrixToShortString() {
        val matrix = Matrix()
        Log.d("Matrix", matrix.toShortString()) // [1.0, 0.0, 0.0][0.0, 1.0, 0.0][0.0, 0.0, 1.0]
    }

    private fun matrixToString() {
        val matrix = Matrix()
        Log.d("Matrix", matrix.toString()) // Matrix{[1.0, 0.0, 0.0][0.0, 1.0, 0.0][0.0, 0.0, 1.0]}
    }

    private fun matrixHashCode() {
        val matrix = Matrix()
        val hashCode = matrix.hashCode()
        Log.d("Matrix", "hashCode = $hashCode") // 44
    }

    private fun matrixEquals() {
        val matrix1 = Matrix()
        val matrix2 = Matrix()
        Log.d("Matrix", "equals = ${matrix1 == matrix2}") // true
        matrix1.setRotate(10f)
        Log.d("Matrix", "equals = ${matrix1 == matrix2}") // false
    }

    private fun matrixCreate() {
        val matrix1 = Matrix()
        val matrix2 = Matrix(matrix1)
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.translate(width / 2f, height / 2f)

        val text1 = "Matrix 基础，主要是一些方法的使用，请看控制台日志"
        // source: 文本内容
        // TextPaint: 画笔
        // width: 是文字区域的宽度，文字到达这个宽度后就会自动换行；
        // align: 是文字的对齐方向；
        // spacingmult: 是行间距的倍数，通常情况下填 1 就好；
        // spacingadd: 是行间距的额外增加值，通常情况下填 0 就好；
        // includeadd: 是指是否在文字上下添加额外的空间，来避免某些过高的字符的绘制出现越界。
        val staticLayout = StaticLayout(
            text1, mTextPaint, 800,
            Layout.Alignment.ALIGN_NORMAL, 1f, 0f, true
        )
        staticLayout.draw(canvas)
    }
}