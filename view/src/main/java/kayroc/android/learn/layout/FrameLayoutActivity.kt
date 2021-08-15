package kayroc.android.learn.layout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kayroc.android.learn.R

/**
 * FrameLayout 帧布局的使用
 * API文档：https://developer.android.google.cn/reference/android/widget/FrameLayout
 * @author kayroc
 */
class FrameLayoutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frame_layout)
    }
}