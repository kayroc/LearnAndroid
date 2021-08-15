package kayroc.android.learn.layout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kayroc.android.learn.R

/**
 * HorizontalScrollView 水平滚动视图的使用
 * API文档：https://developer.android.google.cn/reference/android/widget/HorizontalScrollView
 * @author kayroc
 */
class HorizontalScrollViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_horizontal_scroll_view)
    }
}