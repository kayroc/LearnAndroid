package kayroc.android.learn.layout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kayroc.android.learn.R

/**
 * RelativeLayout 相对布局的使用
 * 官方文档：https://developer.android.google.cn/guide/topics/ui/layout/relative?hl=zh-cn
 * API文档：https://developer.android.google.cn/reference/android/widget/RelativeLayout
 * @author kayroc
 */
class RelativeLayoutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_relative_layout)
    }
}