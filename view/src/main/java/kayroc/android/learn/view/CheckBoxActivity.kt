package kayroc.android.learn.view

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kayroc.android.learn.R

/**
 * CheckBox 复选框的使用
 * 官方文档：https://developer.android.google.cn/guide/topics/ui/controls/checkbox
 * API文档：https://developer.android.google.cn/reference/android/widget/CheckBox
 * @author kayroc
 */
class CheckBoxActivity : AppCompatActivity(), CompoundButton.OnCheckedChangeListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_box)

        val mCheckBox1 = findViewById<CheckBox>(R.id.checkBox)
        val mCheckBox2 = findViewById<CheckBox>(R.id.checkBox2)
        val mCheckBox3 = findViewById<CheckBox>(R.id.checkBox3)

        // 多选框监听事件
        mCheckBox1.setOnCheckedChangeListener(this)
        mCheckBox2.setOnCheckedChangeListener(this)
        mCheckBox3.setOnCheckedChangeListener(this)

        // 获取结果
        val mBtnResult = findViewById<Button>(R.id.btn_result)
        mBtnResult.setOnClickListener {
            val stringBuilder = StringBuilder()
            if (mCheckBox1.isChecked) {
                stringBuilder.append(mCheckBox1.text.toString())
            }
            if (mCheckBox2.isChecked) {
                if (stringBuilder.isEmpty()) {
                    stringBuilder.append(mCheckBox2.text.toString())
                } else {
                    stringBuilder.append("、").append(mCheckBox2.text.toString())
                }
            }
            if (mCheckBox3.isChecked) {
                if (stringBuilder.isEmpty()) {
                    stringBuilder.append(mCheckBox3.text.toString())
                } else {
                    stringBuilder.append("、").append(mCheckBox3.text.toString())
                }
            }
            Toast.makeText(this, stringBuilder.toString(), Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        if (isChecked) {
            Toast.makeText(this, "已选择 : " + buttonView?.text.toString(), Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "已移除 : " + buttonView?.text.toString(), Toast.LENGTH_SHORT).show()
        }
    }
}