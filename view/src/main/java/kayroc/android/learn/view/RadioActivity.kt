package kayroc.android.learn.view

import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kayroc.android.learn.R

/**
 * RadioGroup *  & RadioButton 单选按钮的使用
 * 官方文档：https://developer.android.google.cn/guide/topics/ui/controls/radiobutton
 * API文档：https://developer.android.google.cn/reference/android/widget/RadioGroup
 *         https://developer.android.google.cn/reference/android/widget/RadioButton
 * @author kayroc
 */
class RadioActivity : AppCompatActivity() {
    private val mRadioGroup: RadioGroup by lazy { findViewById<RadioGroup>(R.id.radioGroup) }
    private val mRadioButton: RadioButton by lazy { findViewById<RadioButton>(R.id.radioButton) }
    private val mRadioButton2: RadioButton by lazy { findViewById<RadioButton>(R.id.radioButton2) }
    private val mRadioButton3: RadioButton by lazy { findViewById<RadioButton>(R.id.radioButton3) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_radio)

        // 单选框监听事件
        mRadioGroup.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.radioButton -> Toast.makeText(this, "选项一", Toast.LENGTH_SHORT).show()
                R.id.radioButton2 -> Toast.makeText(this, "选项二", Toast.LENGTH_SHORT).show()
                R.id.radioButton3 -> Toast.makeText(this, "选项三", Toast.LENGTH_SHORT).show()
            }
        }
    }
}