package kayroc.android.learn.view

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kayroc.android.learn.R

/**
 * TextView 文本框视图的使用
 * 官方文档：
 *      自动调整文字大小：https://developer.android.google.cn/guide/topics/ui/look-and-feel/autosizing-textview
 *      可下载字体：https://developer.android.google.cn/guide/topics/ui/look-and-feel/downloadable-fonts
 *      xml中的大小：https://developer.android.google.cn/guide/topics/ui/look-and-feel/fonts-in-xml
 *      表情符号兼容性：https://developer.android.google.cn/guide/topics/ui/look-and-feel/emoji-compat
 *      放大镜微件：https://developer.android.google.cn/guide/topics/text/magnifier
 *      Span：https://developer.android.google.cn/guide/topics/text/spans
 * API文档：https://developer.android.google.cn/reference/android/widget/TextView
 * @author kayroc
 */
class TextViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_view)

        val mTextView = findViewById<TextView>(R.id.textView)
        mTextView.text = "你好，文本框视图"
    }
}