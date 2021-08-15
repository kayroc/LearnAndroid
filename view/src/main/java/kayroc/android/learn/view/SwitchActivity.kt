package kayroc.android.learn.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kayroc.android.learn.R

/**
 * Switch 开关的使用
 * API文档：https://developer.android.google.cn/reference/kotlin/android/widget/Switch
 * @author kayroc
 */
class SwitchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_switch_button)
    }
}