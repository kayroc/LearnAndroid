package kayroc.android.learn.layout

import android.os.Bundle
import android.widget.ScrollView
import androidx.appcompat.app.AppCompatActivity
import kayroc.android.learn.R

/**
 * ScrollView 垂直滚动视图的使用
 * API文档：https://developer.android.google.cn/reference/android/widget/ScrollView
 * @author kayroc
 */
class ScrollViewActivity : AppCompatActivity() {
    private val mScrollView: ScrollView by lazy { findViewById<ScrollView>(R.id.scrollView) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scroll_view)

        // 滚动到底部
        // mScrollView.fullScroll(ScrollView.FOCUS_DOWN)

        // 滚动到顶部
        // mScrollView.fullScroll(ScrollView.FOCUS_UP)
    }
}