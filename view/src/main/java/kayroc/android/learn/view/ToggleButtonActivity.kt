package kayroc.android.learn.view

import android.os.Bundle
import android.widget.Toast
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity
import kayroc.android.learn.R

/**
 * ToggleButton 开关按钮的使用
 * 官方文档：https://developer.android.google.cn/guide/topics/ui/controls/togglebutton
 * API文档：https://developer.android.google.cn/reference/android/widget/ToggleButton
 * @author kayroc
 */
class ToggleButtonActivity : AppCompatActivity() {
    private val mToggleButton: ToggleButton by lazy { findViewById<ToggleButton>(R.id.toggleButton) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toggle_button)

        mToggleButton.setOnCheckedChangeListener { buttonView, _ ->
            Toast.makeText(this, buttonView.text.toString(), Toast.LENGTH_SHORT).show()
        }
    }
}