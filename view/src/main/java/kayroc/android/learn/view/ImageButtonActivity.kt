package kayroc.android.learn.view

import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kayroc.android.learn.R

/**
 * ImageButton 图片按钮的使用
 * API文档：https://developer.android.goole.cn/reference/android/widget/ImageButton
 * @author kayroc
 */
class ImageButtonActivity : AppCompatActivity() {

    private var isOpen = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_button)

        val mImageButton = findViewById<ImageButton>(R.id.imageButton)
        mImageButton.setOnClickListener {
            if (!isOpen) {
                isOpen = true
                mImageButton.setImageResource(android.R.drawable.btn_star_big_on)
            } else {
                isOpen = false
                mImageButton.setImageResource(android.R.drawable.btn_star_big_off)
            }
        }
        mImageButton.setOnLongClickListener {
            Toast.makeText(this, "按钮被长按了", Toast.LENGTH_SHORT).show()
            true
        }
    }
}