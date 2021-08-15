package kayroc.android.learn.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kayroc.android.learn.R

/**
 * ProgressBar 进度条的使用
 * API文档：https://developer.android.google.cn/reference/android/widget/ProgressBar
 * @author kayroc
 */
class ProgressBarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progress_bar)
    }
}