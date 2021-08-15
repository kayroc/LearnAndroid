package kayroc.android.learn.view

import android.os.Bundle
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import kayroc.android.learn.R

/**
 * SeekBar 拖动条的使用
 * API文档：https://developer.android.google.cn/reference/android/widget/SeekBar
 * @author kayroc
 */
class SeekBarActivity : AppCompatActivity() {
    private val mSeekBar: SeekBar by lazy { findViewById<SeekBar>(R.id.seekBar) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seek_bar)

        mSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                // 进度发生改变时会触发
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                // 按住 SeekBar 时会触发
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                // 放开 SeekBar 时触发
            }

        })
    }
}