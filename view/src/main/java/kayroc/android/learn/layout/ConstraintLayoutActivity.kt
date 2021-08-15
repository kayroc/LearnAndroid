package kayroc.android.learn.layout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kayroc.android.learn.R

/**
 * ConstraintLayout 约束布局的使用
 * 官网介绍：https://developer.android.google.cn/training/constraint-layout/index.html
 * API介绍：https://developer.android.google.cn/reference/android/support/constraint/ConstraintLayout.html
 * github：https://constraintlayout.github.io 备用地址：https:/constraintlayout.com/
 * @author kayroc
 */
class ConstraintLayoutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constraint_layout)
    }
}