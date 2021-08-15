package kayroc.android.learn.view

import android.os.Bundle
import android.view.SoundEffectConstants
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kayroc.android.learn.R

/**
 * Button 按钮的使用
 * 官方文档：https://developer.android.google.cn/guide/topics/ui/controls/button
 * API文档：https://developer.android.google.cn/reference/android/widget/Button
 * @author kayroc
 */
class ButtonActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_button)

        val mBtn = findViewById<Button>(R.id.btn)
        mBtn.setOnClickListener {
            // Button 的点击事件
            mBtn.playSoundEffect(SoundEffectConstants.CLICK)
            Toast.makeText(this, "按钮被点击了", Toast.LENGTH_SHORT).show()
        }
        mBtn.setOnLongClickListener {
            Toast.makeText(this, "按钮被长按了", Toast.LENGTH_SHORT).show()
            true
        }
    }
}