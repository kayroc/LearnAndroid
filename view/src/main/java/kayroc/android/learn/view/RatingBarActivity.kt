package kayroc.android.learn.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kayroc.android.learn.R

/**
 * RatingBar 评分条的使用
 * API文档：https://developer.android.google.cn/reference/android/widget/RatingBar
 * @author kayroc
 */
class RatingBarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rating_bar)
    }
}