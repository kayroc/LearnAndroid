package kayroc.android.learn

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.content.res.TypedArray
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.RippleDrawable
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat


/**
 * 涟漪动画(水波纹)
 * @author kayroc
 */
class RippleEffectActivity : AppCompatActivity() {
    private val mTv3: TextView by lazy { findViewById<TextView>(R.id.tv3) }
    private val mTv4: TextView by lazy { findViewById<TextView>(R.id.tv4) }
    private val mTv7: TextView by lazy { findViewById<TextView>(R.id.tv7) }
    private val mTv8: TextView by lazy { findViewById<TextView>(R.id.tv8) }


    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ripple_effect)

        val attrs = intArrayOf(R.attr.selectableItemBackground, R.attr.selectableItemBackgroundBorderless)
        val typedArray: TypedArray = obtainStyledAttributes(attrs)
        // 获取系统有边界资源
        val selectableItemBackground = typedArray.getResourceId(0, 0)
        mTv3.setBackgroundResource(selectableItemBackground)
        // 获取系统无边界资源
        val selectableItemBackgroundBorderless = typedArray.getResourceId(1, 0)
        mTv4.setBackgroundResource(selectableItemBackgroundBorderless)
        typedArray.recycle()

        val purple200 = ContextCompat.getColor(this, R.color.purple_200)
        val colorStateList = ColorStateList(arrayOf(intArrayOf()), intArrayOf(purple200))
        // 自定义有边界 drawable
        val contentDrawable = GradientDrawable().apply {
            val teal200 = ContextCompat.getColor(baseContext, R.color.teal_200)
            color = ColorStateList(arrayOf(intArrayOf()), intArrayOf(teal200))
        }
        val selectableItemDrawable = RippleDrawable(colorStateList, contentDrawable, null)
        mTv7.background = selectableItemDrawable
        // 自定义无边界 drawable
        val selectableItemDrawableBorderless = RippleDrawable(colorStateList, null, null)
        mTv8.background = selectableItemDrawableBorderless
    }
}