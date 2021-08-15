package kayroc.android.learn.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kayroc.android.learn.R

/**
 * ImageView 的使用
 * API文档：https://developer.android.google.cn/reference/android/widget/ImageView
 * @author kayroc
 */
class ImageViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_view)
    }
}