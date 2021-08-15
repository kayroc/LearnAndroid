package kayroc.android.learn.layout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kayroc.android.learn.R

/**
 * LinearLayout 线性布局的使用
 * 官方文档：https://developer.android.google.cn/guide/topics/ui/layout/linear?hl=zh-cn
 * API文档：https://developer.android.google.cn/reference/android/widget/LinearLayout
 * @author kayroc
 */
class LinearLayoutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_linear_layout)
    }
}