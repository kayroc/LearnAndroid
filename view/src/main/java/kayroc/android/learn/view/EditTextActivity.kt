package kayroc.android.learn.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kayroc.android.learn.R

/**
 * EditText 编辑框的使用
 * API文档：https://developer.android.google.cn/reference/android/widget/EditText
 * @author kayroc
 */
class EditTextActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_text)
    }
}